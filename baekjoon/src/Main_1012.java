import java.io.*;
import java.util.*;

public class Main_1012 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int board[][];
    static boolean visited[][];
    static int n,m,k;
    static int ans = 0;
    public static void main(String[] args) throws Exception{

        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            board = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(board[i][j] == 1 && !visited[i][j]) bfs(i,j);
                }
            }
            bw.write(ans+"\n");
        }
        bw.flush();

    }

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    private static void bfs(int x, int y) {
        ans++;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i = 0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx][ny] != 1) continue;
                if(visited[nx][ny]) continue;
                q.add(new Point(nx,ny));
                visited[nx][ny] = true;
            }
        }

    }
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
