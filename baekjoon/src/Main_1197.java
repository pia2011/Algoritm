import java.io.*;
import java.util.*;

public class Main_1197{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int v,e;
    static int parent[];
    static int rank[];
    static ArrayList<Edge> edgeList;
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        rank = new int[v+1];
        parent = new int[v+1];
        for(int i = 1; i<=v; i++){
            parent[i] =  i;
        }
        edgeList = new ArrayList<>();

        for(int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(a,b,w));
        }

        Collections.sort(edgeList);

        long ans = 0;
        // 크루스칼 알고리즘
        for(Edge e : edgeList){
            if(find(e.start) != find(e.end)){
                union(e.start,e.end);
                ans += e.weight;
            }
        }
        bw.write(ans+"\n");
        bw.flush();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return;
        if(rank[a] > rank[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }
        parent[a] = b;
        if(rank[a] == rank[b]) ++rank[b];
    }
    private static int find(int u){
        if(parent[u] == u) return u;
        else return parent[u] = find(parent[u]);
    }

    static class Edge implements Comparable<Edge>{
        int start, end, weight;

        public Edge(int from, int to, int weight) {
            this.start = from;
            this.end = to;
            this.weight = weight;
        }

        public int compareTo(Edge o){
            return weight - o.weight;
        }
    }

}