import java.io.*;
import java.util.*;

public class Main_2667 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static char board[][];
    static boolean visited[][];
    static ArrayList<Integer> ans;
    static int n;
    static int count = 0;
    public static void main(String[] args) throws Exception{

        ans = new ArrayList<>();

        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i<n; i++){
            board[i] = br.readLine().toCharArray();
        }

        searchAll();
        Collections.sort(ans);
        bw.write(count+"\n");
        for(int x : ans){
            bw.write(x+"\n");
        }
        bw.flush();
    }

    private static void searchAll() {
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == '1' && !visited[i][j]) bfs(i,j);
            }
        }
    }

    static int dx[] = {0,-1,0,1};
    static int dy[] = {1,0,-1,0};
    private static void bfs(int x, int y) {
        count++;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i = 0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(board[nx][ny] != '1') continue;
                if(visited[nx][ny]) continue;
                cnt++;
                q.add(new Point(nx,ny));
                visited[nx][ny] = true;
            }
        }
        ans.add(cnt);
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
