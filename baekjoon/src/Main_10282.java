import java.io.*;
import java.util.*;

public class Main_10282{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,d,c;
    static ArrayList<Node> adj[];
    static int dist[];
    public static void main(String[] args) throws Exception{

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 정점개수
            d = Integer.parseInt(st.nextToken()); // 간선개수
            c = Integer.parseInt(st.nextToken()); // 시작점

            adj = new ArrayList[n + 1];
            for(int i = 1; i<=n; i++){
                adj[i] = new ArrayList<>();
            }

            for(int i = 0; i<d; i++){
                st = new StringTokenizer(br.readLine());

                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                adj[from].add(new Node(to, s));
            }

            dijkstra(c);

            int maxTime = 0;
            int cnt = 0;

            for(int i = 1; i<=n; i++){
                if(dist[i] != Integer.MAX_VALUE){
                    cnt++;
                    maxTime = Math.max(maxTime, dist[i]);
                }
            }
            bw.write(cnt+" "+ maxTime+"\n");
        }
        bw.flush();

    }

    private static void dijkstra(int start) {

        dist = new int[n + 1];
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
            return weight - o.weight; // 오름차순
        }
    }
}