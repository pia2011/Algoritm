import java.io.*;
import java.util.*;

public class Main_1405{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static double n,west,north,south,east;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static double percent[];
    static double ans = 0;
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        percent = new double[4];
        for(int i = 0; i<4; i++){
            percent[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        boolean visited[][] = new boolean[29][29];
        visited[14][14] = true;
        dfs(0, 14, 14, visited, 1);

        System.out.println(ans);

    }

    // 백트래킹
    static void dfs(int cnt, int x, int y, boolean visited[][], double result){

        if(cnt == n){
            ans += result;
            return;
        }

        for(int i = 0; i<4; i++){ // 동서남북
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 15 - 14  ~ 15 + 14
            if(nx < 0 || ny < 0 || nx >= 29 || nx >= 29 ) continue;
            if(visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(cnt+1, nx, ny, visited, result * percent[i]);
            visited[nx][ny] = false;
        }

    }


}