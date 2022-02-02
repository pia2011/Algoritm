import java.io.*;
import java.util.*;

public class Main_2178 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int dist[][];
    static int board[][];
    static int n,m;
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n + 1][m + 1] ;
        board = new int[n + 1][m + 1];
        for(int i = 1; i<=n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i<n; i++){
            String input = br.readLine();
            for(int j = 0; j<m; j++){
                board[i+1][j+1] = input.charAt(j) - '0';
            }
        }
        bfs();
        bw.write(dist[n][m]+"\n");
        bw.flush();
    }
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static void bfs() throws Exception{
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(1,1));
        dist[1][1] = 1;

        while(!q.isEmpty()){
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            for(int i = 0; i<4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx <= 0 || nx > n || ny <= 0 || ny > m) continue; // 범위
                if(board[nx][ny] == 0) continue; // 벽
                if(dist[nx][ny] <= dist[x][y] + 1) continue; // 거리

                q.add(new Point(nx,ny));
                dist[nx][ny] = dist[x][y] + 1;
            }

        }
    }

    static class Point{
        int x; int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
