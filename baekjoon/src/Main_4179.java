import java.io.*;
import java.util.*;

public class Main_4179{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[][] board;
    static int[][] dist;
    static int n,m;
    static Jihun jihun;
    static Fire fire;
    static boolean visited[][];
    static Queue<Fire> fires = new LinkedList<>();
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new String[n][m];
        visited = new boolean[n][m];
        dist = new int[n][m];

        for(int i = 0; i<n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i<n; i++){
            String input = br.readLine();
            for(int j = 0; j<m; j++){
                board[i][j] = String.valueOf(input.charAt(j));

                if(board[i][j].equals("J")){
                    jihun = new Jihun(i,j,0);
                    visited[i][j] = true;
                }else if(board[i][j].equals("F")){
                    fires.add(new Fire(i,j,0));
                    dist[i][j] = 0;
                }
            }
        }

        bfs();
    }

    static int dx[] = {0,1,-1,0};
    static int dy[] = {1,0,0,-1};
    private static void bfs() {
        Queue<Jihun> jihuns = new LinkedList<>();
        jihuns.add(jihun);

        while(!fires.isEmpty()){
            fire = fires.poll();

            for(int i = 0; i<4; i++){
                int nx = dx[i] + fire.x;
                int ny = dy[i] + fire.y;

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx][ny].equals("#")) continue;
                if(dist[nx][ny] <= fire.cnt + 1) continue;

                dist[nx][ny] = fire.cnt + 1;
                fires.add(new Fire(nx,ny,fire.cnt+1));
            }
        }

        while(!jihuns.isEmpty()){

            jihun = jihuns.poll();

            for(int i = 0; i<4; i++){
                int nx = dx[i] + jihun.x;
                int ny = dy[i] + jihun.y;
                // 종료 조건
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    System.out.println(jihun.cnt + 1);
                    return;
                }

                if(board[nx][ny].equals("F")) continue;
                if(board[nx][ny].equals("#")) continue;
                if(dist[nx][ny] <= jihun.cnt + 1) continue;
                if(visited[nx][ny]) continue;

                jihuns.add(new Jihun(nx,ny,jihun.cnt + 1));
                visited[nx][ny] = true;
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    static class Jihun{
        int x, y, cnt;

        public Jihun(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static class Fire{
        int x, y, cnt;

        public Fire(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}