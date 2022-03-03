import java.io.*;
import java.util.*;

public class Main_23290 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<Integer> fishes[][];
    static ArrayList<Integer> copyedFish[][];
    static int smell[][];


    static int m,s;
    static int sharkX,sharkY;
    static int max;
    static ArrayList<Integer> sharkRoute;
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 물고기 수
        s = Integer.parseInt(st.nextToken()); // 게임 횟수
        fishes = new ArrayList[5][5];
        copyedFish = new ArrayList[5][5];
        smell = new int[5][5];
        for(int i = 1; i<=4; i++){
            for(int j = 1; j<=4; j++){
                fishes[i][j] = new ArrayList<>();
                copyedFish[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;

            fishes[x][y].add(d);
        }

        st = new StringTokenizer(br.readLine());
        sharkX = Integer.parseInt(st.nextToken());
        sharkY = Integer.parseInt(st.nextToken());

        for(int i = 1; i<=s; i++){

            copyFish();
            moveFish();
            max = -1;
            sharkRoute = new ArrayList<>();

            searchBestPath(new ArrayList<>());
            moveShark(i);
            removeSmell(i);
            pasteFish();


        }

        int ans = 0;
        for(int i = 1; i<=4; i++){
            for(int j = 1; j<=4; j++){
                ans += fishes[i][j].size();
            }
        }

        bw.write(ans+"\n");
        bw.flush();
    }

    private static void pasteFish() {
        for(int i = 1; i<=4; i++){
            for(int j = 1; j<=4; j++){
                for(int dir : copyedFish[i][j]){
                    fishes[i][j].add(dir);
                }
            }
        }
    }

    // 확인
    private static void removeSmell(int time) {
        for(int i = 1; i<=4; i++){
            for(int j = 1; j<=4; j++){
                if(smell[i][j] == 0) continue;
                if(time - smell[i][j] == 2){
                    smell[i][j] = 0;
                }
            }
        }
    }

    // 백트래킹
    private static void searchBestPath(ArrayList<Integer> route){

        // 조합을 구성했으면 시뮬레이션 돌려보자
        if(route.size() == 3){

            int eatCnt = simulateShark(route);

            if(eatCnt > max){
                max = eatCnt;
                sharkRoute.clear();
                for(int dir : route){
                    sharkRoute.add(dir);
                }
            }
            return;
        }
        for(int i = 0; i<4; i++){
            route.add(i);
            searchBestPath(route);
            route.remove(route.size() - 1);
        }
    }

    private static int simulateShark(ArrayList<Integer> route){
        int ret = 0;
        boolean visited[][] = new boolean[5][5];

        int nx = sharkX;
        int ny = sharkY;
        for(int i = 0; i<3; i++){
            int dir = route.get(i);

            nx += sdx[dir];
            ny += sdy[dir];

            if(nx < 1 || nx > 4 || ny < 1 || ny > 4) return -1;
            if(visited[nx][ny]) continue;

            visited[nx][ny] = true;
            ret += fishes[nx][ny].size();

        }

        return ret;
    }

    static int sdx[] = {-1,0,1,0};
    static int sdy[] = {0,-1,0,1};
    private static void moveShark(int time) {

        for(int dir : sharkRoute){
            sharkX += sdx[dir];
            sharkY += sdy[dir];
            if(!fishes[sharkX][sharkY].isEmpty()){
                fishes[sharkX][sharkY].clear();
                smell[sharkX][sharkY] = time;
            }
        }
    }


    static int dx[] = {0,-1,-1,-1,0,1,1,1};
    static int dy[] = {-1,-1,0,1,1,1,0,-1};
    private static void moveFish() {

        ArrayList<Integer> [][] temp = new ArrayList[5][5];
        for(int i = 1; i<=4; i++){
            for(int j = 1; j<=4; j++){
                temp[i][j] = new ArrayList<>();
            }
        }

        for(int x = 1; x<=4; x++){
            for(int y = 1; y<=4; y++){
                for(int d : fishes[x][y]){
                    boolean flag = false;
                    int dir = d;
                    for(int k = 0; k<8; k++){
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        // 조건에 맞아야지만 이동
                        if(nx >= 1 && nx <= 4 && ny >= 1 && ny <= 4){
                            if(sharkX != nx || sharkY != ny){
                                if(smell[nx][ny] == 0){
                                    flag = true;
                                    temp[nx][ny].add(dir);
                                    break;
                                }
                            }
                        }
                        // 조건에 맞지 않으면 반시계 방향으로 회전
                        dir = countClock(dir);
                    }

                    // 만약 이동할 수 없었다면 그 자리 고수
                    if(flag == false){
                        temp[x][y].add(d);
                    }

                }

            }
        }

        fishes = temp;
    }

    private static int countClock(int dir) {
        if(dir == 0){
            return 7;
        }else{
            return dir - 1;
        }
    }


    private static void copyFish() {

        for(int i = 1; i<=4; i++){
            for(int j = 1; j<=4; j++){
                copyedFish[i][j] = fishes[i][j];
            }
        }
    }

}
