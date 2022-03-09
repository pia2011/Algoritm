import java.io.*;
import java.util.*;

public class Main_21772{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m,k;
    static char[][] board;
    static int ans = 0;
    public static void main(String[] args) throws Exception{

        // 고구마를 최대한 많이 먹도록 구성
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int x = 0,y = 0;
        board = new char[n][m];
        for(int i = 0; i<n; i++){
            String input = br.readLine();
            for(int j = 0; j<m; j++){
                board[i][j] = input.charAt(j);
                if(board[i][j] == 'G'){
                    x = i;
                    y = j;
                }
            }
        }

        ate = new boolean[n][m];
        dfs(x,y,0, 0);
        System.out.println(ans);
    }

    static int dx[] = {0,1,0,-1,0};
    static int dy[] = {1,0,-1,0,0};
    static boolean ate[][];
    private static void dfs(int x, int y, int cnt, int s) {
        if(cnt >= k){
            ans = Math.max(s, ans);
            return;
        }

        for(int i = 0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(board[nx][ny] == '#') continue;

            if(board[nx][ny] == 'S'){
                if(ate[nx][ny]){
                    dfs(nx,ny,cnt+1,s);
                }else{
                    ate[nx][ny] = true;
                    dfs(nx,ny,cnt+1,s + 1);
                    ate[nx][ny] = false;
                }
            }else{ // . or G
                dfs(nx,ny,cnt + 1,s);
            }
        }
    }

}
