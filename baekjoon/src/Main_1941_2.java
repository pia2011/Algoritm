import java.io.*;
import java.util.*;

public class Main_1941_2{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char board[][];
    static int n = 5;
    static int combX[];
    static int combY[];
    static int ans = 0;
    public static void main(String[] args) throws Exception{

        board = new char[n][n];
        for(int i = 0; i<n; i++){
            board[i] = br.readLine().toCharArray();
        }

        combX = new int[25];
        combY = new int[25];
        for(int i = 0; i<n*n; i++){
            combX[i] = i/5;
            combY[i] = i%5;
        }

        select = new int[7];
        checked = new boolean[25];
        dfs(0,0, 0);
        System.out.println(ans);

    }

    static boolean checked[];
    static int select[];
    private static void dfs(int cnt, int idx, int cntS) {

        if(cnt == 7){ // 기저사례
            if(cntS >= 4 && bfs()) ans++;
            return;
        }

        // 백트래킹
        for(int i = idx; i<25; i++){
            if(checked[i]) continue;

            checked[i] = true;
            select[cnt] = i;
            if(board[combX[i]][combY[i]] == 'S') dfs(cnt+1, i + 1, cntS + 1);
            else dfs(cnt+1, i + 1, cntS);

            checked[i] = false;

        }
    }

    static int dx[] = {0,1,-1,0};
    static int dy[] = {1,0,0,-1};
    private static boolean bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(combX[select[0]],combY[select[0]]));
        boolean visited[][] = new boolean[5][5];
        visited[combX[select[0]]][combY[select[0]]] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i = 0; i<4; i++){
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(visited[nx][ny]) continue;
                if(!checked[nx*5 + ny]) continue;

                visited[nx][ny] = true;
                cnt++;
                q.add(new Point(nx,ny));
            }
        }

        if(cnt == 7) return true;
        else return false;
    }

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}