import java.io.*;
import java.util.*;

public class Main_2589{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static char[][] board;
    static boolean visited[][];
    static int ans = 0;
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for(int i = 0; i<n; i++){
            board[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 'L')
                    ans = Math.max(bfs(i,j),ans);
            }
        }

        System.out.println(ans);

    }

    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,-1,0,1};
    private static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y,0));
        visited = new boolean[n][m];
        visited[x][y] = true;
        int ret = 0;
        while(!q.isEmpty()){
            Point now = q.poll();

            ret = Math.max(ret, now.cnt);

            for(int i = 0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx][ny] == 'W') continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new Point(nx,ny,now.cnt + 1));
            }
        }

        return ret;
    }

    static class Point {
        int x,y,cnt;
        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}