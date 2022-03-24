import java.io.*;
import java.util.*;

public class Main_5427{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static char board[][];
    static Queue<Fire> fires;
    static Queue<Point> q;
    static int dist[][];
    static boolean visited[][];
    public static void main(String[] args) throws Exception{

        // 불은 계속 퍼저나간다.
        int t = Integer.parseInt(br.readLine());

        while(t-->0){

            fires = new LinkedList<>();
            q = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            board = new char[n][m];
            dist = new int[n][m];
            visited = new boolean[n][m];

            for(int i = 0; i<n; i++){
                String input = br.readLine();
                for(int j = 0; j<m; j++){
                    board[i][j] = input.charAt(j);
                    dist[i][j] = -1;
                    if(board[i][j] == '@'){ // 상근이의 위치
                        q.add(new Point(i,j,0));
                        visited[i][j] = true;
                    }else if(board[i][j] == '*'){
                        fires.add(new Fire(i,j,0));
                        dist[i][j] = 0;
                    }
                }
            }

            bfs();
        }
        bw.flush();

    }

    // 불 다 번지게 하고 -> 갈 수 있는지 여부를 판단하면서 이동
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    private static void bfs() throws Exception{

        // 불
        while(!fires.isEmpty()){
            Fire fire = fires.poll();
            for(int i = 0; i<4; i++){
                int nx = fire.x + dx[i];
                int ny = fire.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(board[nx][ny] == '#') continue;
                if(dist[nx][ny] >= 0) continue; // 이미 들렸던 곳은 안감

                dist[nx][ny] = fire.cnt + 1;
                fires.add(new Fire(nx,ny,fire.cnt + 1));
            }
        }

//        print();

        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i = 0; i<4; i++){
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;

                if(nx < 0 || ny >= m || nx >= n || ny < 0) {
                    bw.write((now.cnt+1)+"\n");
                    return;
                }
                if(board[nx][ny] == '*') continue;
                if(board[nx][ny] == '#') continue;
                if(visited[nx][ny]) continue;
                if(now.cnt + 1 < dist[nx][ny] || dist[nx][ny] == -1) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, now.cnt + 1));
                }
            }
        }

        bw.write("IMPOSSIBLE\n");

    }

    static void print(){
        System.out.println("============");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===========");
    }

    static class Fire{
        int x, y, cnt;

        public Fire(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static class Point{
        int x,y,cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}