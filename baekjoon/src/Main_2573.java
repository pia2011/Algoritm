import java.io.*;
import java.util.*;

public class Main_2573{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int board[][];
    static boolean isChanged;
    static int ans;
    static boolean visited[][];
    public static void main(String[] args) throws Exception{

        // 두 덩어리!
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        while(true){
            isChanged = false;
            if(isMoreThanTwo()) break;
            if(!isChanged) break;
            ans++;
        }

        if(isChanged){
            bw.write(ans+"\n");
        }else{
            bw.write(0+"\n");
        }
        bw.flush();

    }

    private static boolean isMoreThanTwo() {
        int cnt = 0;
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] != 0 && !visited[i][j]) {
                    bfs(i,j);
                    isChanged = true;
                    cnt++;
                }
            }
        }

        if(cnt >= 2) return true;
        else return false;
    }


    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Point now = q.poll();
            meltIce4ways(now.x,now.y);
            for(int i =0; i<4; i++){
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(board[nx][ny] == 0) continue;
                q.add(new Point(nx,ny));
                visited[nx][ny] = true;
            }
        }
    }

    private static void meltIce4ways(int x, int y) {

        for(int i = 0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(board[nx][ny] == 0 && board[x][y] > 0 && !visited[nx][ny]){
                board[x][y]--;
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