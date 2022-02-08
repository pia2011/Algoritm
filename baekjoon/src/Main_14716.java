import java.io.*;
import java.util.*;

public class Main_14716{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int board[][];
    static boolean visited[][];
    static int ans = 0;
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    bfs(i,j);
                }

            }
        }

        System.out.println(ans);

    }
    static int dx[] = {0,1,0,-1,1,1,-1,-1};
    static int dy[] = {1,0,-1,0,1,-1,1,-1};
    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;
        ans++;
        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i = 0; i<8; i++){
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(board[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.add(new Point(nx,ny));

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
