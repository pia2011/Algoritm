import java.io.*;
import java.util.*;

public class Main_9370{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Node> adj[];
    static ArrayList<Integer> targetList;
    static int n,m,t;
    static int s,g,h;
    static long dist[];
    public static void main(String[] args) throws Exception{

        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // s는 출발지 (g-h)는 무조건 지나가야함

            adj = new ArrayList[n+1];
            for(int i = 1; i<=n; i++){
                adj[i] = new ArrayList<>();
            }


            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken()) * 2;

                if((a == g&&b == h) || (a == h&&b == g)){
                    d -= 1;
                }

                adj[a].add(new Node(b,d));
                adj[b].add(new Node(a,d));
            }

            targetList = new ArrayList<>();

            for(int i = 0; i<t; i++){
                targetList.add(Integer.parseInt(br.readLine()));
            }

            dijkstra();

            Collections.sort(targetList);

            // 홀수면 g - h 경로 포함
            for(int x : targetList){
                if(dist[x] % 2 != 0) bw.write(x + " ");
            }
            bw.write("\n");
        }
        bw.flush();

    }

    private static void dijkstra() {
        dist = new long[n + 1]; // 목적지까지 필요한 거리(누적)
        Arrays.fill(dist, 2000000000);
        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.to] < now.dist) continue;

            for(Node next : adj[now.to]){

                if(dist[next.to] > now.dist + next.dist){
                    dist[next.to] = now.dist + next.dist;
                    pq.add(new Node(next.to, now.dist + next.dist));
                }
            }
        }

    }

    static class Node implements Comparable<Node>{
        int to;
        long dist;

        public Node(int to, long dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.dist,o.dist);
        }
    }
}