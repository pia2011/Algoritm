import java.io.*;
import java.util.*;

public class Main_1937{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int board[][];
    static int dp[][];
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new int[n][n];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                ans = Math.max(dfs(i,j),ans);
            }
        }

        System.out.println(ans);


    }

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    private static int dfs(int x, int y){
        if(dp[x][y] != 0) return dp[x][y];

        dp[x][y] = 1;

        for(int i = 0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if(board[nx][ny] <= board[x][y]) continue;

            dp[x][y] = Math.max(dp[x][y], dfs(nx,ny) + 1);

        }

        return dp[x][y];
    }


}