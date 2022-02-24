import java.io.*;
import java.util.*;

public class Main_9466{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean visited[];
    static boolean finished[];
    static int vote[];
    static int cnt ;
    public static void main(String[] args) throws Exception{

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            cnt = 0;
            vote = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i<=n; i++){
                vote[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i<=n; i++){
                if(!finished[i]) dfs(i);
            }

            bw.write((n-cnt)+"\n");
        }
        bw.flush();
    }

    private static void dfs(int now) {
        if(visited[now]){
            // 한 사이클 돌고나면 들어올 수 있음
            finished[now] = true;
            cnt++;
        }else{
            visited[now] = true;
        }

        if(!finished[vote[now]]) dfs(vote[now]);

        // 한번 탐색했던 곳은 모두 finished처리, visited는 다음 탐색을 위해 초기화
        visited[now] = false;
        finished[now] = true;
    }
}
