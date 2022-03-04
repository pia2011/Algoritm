import java.io.*;
import java.util.*;

public class Main_18352{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m,k,x;
    static ArrayList<Node> adj[];
    static int dist[];
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        // 다 익스트라 초기 설정
        adj = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(new Node(to, 1));
        }

        dijkstra(x);

        ArrayList<Integer> ansList = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            if(dist[i] == k) ansList.add(i);
        }

        if(ansList.size() == 0){
            bw.write(-1+"\n");
        }else{
            for(int x : ansList){
                bw.write(x+"\n");
            }
        }
        bw.flush();
    }

    private static void dijkstra(int x) {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));
        dist[x] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.idx] < now.weight) continue; // 이미 더 좋은 경로가 있을 경우 무시

            for(Node nextNode : adj[now.idx]){ // 연결이 된 곳 중에서
                if(dist[nextNode.idx] > now.weight + nextNode.weight){ // 지금까지 쌓아왔던
                    dist[nextNode.idx] = now.weight + nextNode.weight;
                    pq.add(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
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