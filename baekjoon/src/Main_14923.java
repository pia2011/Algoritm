import java.io.*;
import java.util.*;

public class Main_14923 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int board[][];
    static boolean visited[][][];
    static int n,m;
    static int ans = -1;
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m][2];

        st = new StringTokenizer(br.readLine());
        int hx = Integer.parseInt(st.nextToken()) - 1;
        int hy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken()) - 1;
        int ey = Integer.parseInt(st.nextToken()) - 1;

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(hx,hy,ex,ey);
        bw.write(ans+"\n");
        bw.flush();
    }

    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    private static void bfs(int hx, int hy, int ex, int ey) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(hx,hy, 0,0));
        visited[hx][hy][0] = true;
        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x == ex && now.y == ey){
                ans = now.dist;
                break;
            }

            for(int i = 0; i<4; i++){
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 벽이 있다면 : 이전에 벽을 뚫은적이 없어야함
                if(board[nx][ny] == 1 && now.cnt == 0 && !visited[nx][ny][now.cnt + 1]){
                    q.add(new Point(nx,ny,now.cnt + 1,now.dist + 1));
                    visited[nx][ny][now.cnt + 1] = true;
                }else if(board[nx][ny] == 0 && !visited[nx][ny][now.cnt]){
                    q.add(new Point(nx,ny,now.cnt,now.dist + 1));
                    visited[nx][ny][now.cnt] = true;
                }
            }
        }
    }

    static class Point{
        int x,y,cnt,dist;

        public Point(int x, int y, int cnt, int dist) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dist = dist;
        }
    }
}