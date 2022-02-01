import java.util.*;
import java.io.*;

public class Main_1260 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<Integer> adj[];
    static boolean visited[];
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 초기화
        adj = new ArrayList[n + 1];
        for(int i = 1; i<=n; i++){
            adj[i] = new ArrayList<>();
        }

        // 연결 짓기
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[start].add(end);
            adj[end].add(start);
        }

        // 조건 : 정점 번호가 작은 것 먼저 방문
        for(int i = 1; i<=n; i++){
            Collections.sort(adj[i]);
        }

        // 깊이 탐색
        visited = new boolean[n + 1];
        dfs(v);
        bw.write("\n");

        // 너비 탐색
        visited = new boolean[n + 1];
        bfs(v);
        bw.write("\n");

        bw.flush();
        bw.close();
    }

    private static void dfs(int now) throws IOException{
        if(visited[now]) return;

        visited[now] = true;
        bw.write(now + " ");

        for(int next : adj[now]){
            dfs(next);
        }

    }

    private static void bfs(int start) throws IOException{
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        bw.write(start+" ");
        while(!q.isEmpty()){
            int node = q.poll();
            for(int next : adj[node]){
                if(visited[next]) continue;
                visited[next] = true;
                bw.write(next+" ");
                q.add(next);
            }
        }


    }

}
