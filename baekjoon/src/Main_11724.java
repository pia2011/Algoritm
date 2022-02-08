import java.io.*;
import java.util.*;

public class Main_11724 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer> adj[];
    static int n,m;
    static boolean visited[];
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        adj = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        int ans = 0;
        for(int i = 1; i<=n; i++){
            if(!visited[i]) {
                ans++;
                dfs(i);
            }
        }
        System.out.println(ans);

    }

    private static void dfs(int now) {
        if(visited[now]) return ;

        visited[now] = true;

        for(int next : adj[now]){
            dfs(next);
        }
    }


}
