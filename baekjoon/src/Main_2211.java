import java.io.*;
import java.util.*;

public class Main_2211{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static ArrayList<Node> adj[];
    static int dist[];
    static int source[];
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            adj[i] = new ArrayList<>();
        }


        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b,c));
            adj[b].add(new Node(a,c));
        }
        source = new int[n + 1];
        dijkstra(1);

        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        for(int i = 1; i<=n; i++){
            if(source[i] != 0) {
                cnt++;
                ans.append(i+" "+source[i]+"\n");
            }
        }

        bw.write(cnt+"\n"+ans);
        bw.flush();
    }

    private static void dijkstra(int start) {
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.idx] < now.weight) continue;
            for(Node nextNode : adj[now.idx]){
                if(dist[nextNode.idx] > now.weight + nextNode.weight){
                    dist[nextNode.idx] = now.weight + nextNode.weight;
                    // 경로도 최신화
                    source[nextNode.idx] = now.idx;
                    pq.add(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }
    }

    private static class Node implements Comparable<Node>{
        int idx, weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        public int compareTo(Node o){
            return weight - o.weight;
        }
    }

}