import java.io.*;
import java.util.*;

public class Main_2606{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n,m;
    static ArrayList<Integer> adj[];
    static boolean visited[];
    static int cnt;
    public static void main(String[] args) throws Exception{
        cnt = 0;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adj = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        bfs(1);
        bw.write(cnt+"\n");
        bw.flush();

    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : adj[now]){
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }

        }
    }
}