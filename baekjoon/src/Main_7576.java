import java.io.*;
import java.util.*;

public class Main_7576{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int board[][];
    static int n,m;
    static Queue<Point> q;
    static int ans = 0;
    public static void main(String[] args) throws Exception{

        q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) q.add(new Point(i,j));
            }
        }

        bfs();

        if(isRight()){
            bw.write(ans+"\n");
        }else{
            bw.write(-1+"\n");
        }
        bw.flush();

    }

    private static boolean isRight() {

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 0){
                    return false;
                }

            }
        }
        return true;
    }

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    private static void bfs() {

        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i = 0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx][ny] != 0) continue;

                board[nx][ny] = board[now.x][now.y] + 1;
                ans = Math.max(ans, board[nx][ny] - 1);
                q.add(new Point(nx,ny));
            }
        }
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}