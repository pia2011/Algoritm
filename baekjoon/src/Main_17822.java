import java.io.*;
import java.util.*;

public class Main_17822{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int board[][];
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        board = new int[n + 1][m];
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // x 배수를 d방향으로 k 번 돌린다.
            rotate(x,d,k);
            if(checkAdj()){
                deleteAdj();
            }else{
                addAvg();
            }
        }

        bw.write(sumAll()+"\n");
        bw.flush();

    }

//    private static void printBoard() {
//
//        for(int i = 1; i<=n; i++){
//            for(int j = 0; j<m; j++){
//                System.out.print(board[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }

    private static int sumAll() {
        int ret = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 0; j<m; j++){
                ret+=board[i][j];
            }
        }
        return ret;
    }

    private static void addAvg() {
        int sum = 0;
        int cnt = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 0) continue;
                sum += board[i][j];
                cnt++;
            }
        }

        double avg = sum/(double)cnt;
        for(int i = 1; i<=n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 0) continue;
                if((double)board[i][j] > avg) board[i][j]--;
                else if((double)board[i][j] < avg) board[i][j]++;
            }
        }
    }

    private static void deleteAdj() {
        for(int i = 1; i<=n; i++){
            for(int j = 0; j<m; j++){
                if(visited[i][j]) board[i][j] = 0;
            }
        }
    }

    static boolean visited[][];
    private static boolean checkAdj() {
        visited = new boolean[n + 1][m];
        boolean ret = false;

        for(int i = 1; i<=n; i++){
            for(int j = 0; j<m; j++){
                for(int dir = 0; dir<4; dir++){
                    if(check(i,j,dir)) ret = true;
                }
            }
        }

        return ret;
    }

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    private static boolean check(int x, int y, int dir) {

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(ny == m) ny = 0;
        else if(ny == -1) ny = m - 1;
        if(nx < 1 || nx > n) return false;
        if(board[x][y] == 0) return false;
        if(board[x][y] != board[nx][ny]) return false;

        visited[x][y] = true;
        visited[nx][ny] = true;
        return true;
    }


    private static void rotate(int x, int d, int k) {

        for(int target = x; target<=n; target+=x){

            if(d == 0){
                rotateR(target, k);
            }else{
                rotateL(target, k);
            }
        }

    }

    private static void rotateL(int target, int cnt) {
        int temp[] = new int[m];
        for(int i = 0; i<m; i++){
            temp[(m + i - cnt) % m] = board[target][i];
        }
        board[target] = temp.clone();
    }

    private static void rotateR(int target, int cnt) {
        int temp[] = new int[m];
        for(int i = 0; i<m; i++){
            temp[(i + cnt) % m] = board[target][i];
        }
        board[target] = temp.clone();
    }


}