import java.io.*;
import java.util.*;

public class Main_18404{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int kx,ky;
    static int dist[][];
    static boolean visited[][];
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n+1][n+1];
        st = new StringTokenizer(br.readLine());
        kx = Integer.parseInt(st.nextToken());
        ky = Integer.parseInt(st.nextToken());

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bfs(x,y);
        }
        bw.flush();
    }

    // 메모이제이션
    static int dx[] = {-2,-2,-1,-1,1,1,2,2};
    static int dy[] = {-1,1,-2,2,-2,2,-1,1};
    private static void bfs(int x, int y) throws IOException {
        Queue<Knight> q = new LinkedList<>();
        visited = new boolean[n+1][n+1];
        q.add(new Knight(kx,ky,0));
        visited[kx][ky] = true;
        dist[kx][ky] = 0;
        while(!q.isEmpty()){
            Knight now = q.poll();
            if(dist[x][y] != 0){
                bw.write(dist[x][y] + " ");
                return;
            }

            for(int i = 0; i<8; i++){
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;

                if(nx > n || ny > n || nx <= 0 || ny <= 0) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = now.cnt + 1;
                q.add(new Knight(nx,ny,now.cnt+1));
            }
        }
    }

    static class Knight{
        int x,y,cnt;

        public Knight(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}