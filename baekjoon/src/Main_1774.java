import java.io.*;
import java.util.*;

public class Main_1774{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int parent[];
    static int rank[];

    static ArrayList<Edge> edgeList;
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 분리집합

        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }
        edgeList = new ArrayList<>();

        Point p[] = new Point[n + 1];
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            p[i] = new Point(from,to);
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x,y); // 이미 연결되어 있음 == 이미 같은 그룹
        }

        // 모든 경우 고려
        for(int i = 1; i<=n-1; i++){
            for(int j = i+1; j<=n; j++){
                double dist = calDist(p[i], p[j]);

                edgeList.add(new Edge(i,j,dist));
            }
        }

        // 가중치에 따라 오름차순 정렬
        Collections.sort(edgeList);

        double distSum = 0;
        // 크루스칼 알고리즘
        for(int i = 0; i<edgeList.size(); i++){
            Edge edge = edgeList.get(i);


            if(find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                distSum += edge.dist;
            }
        }

        bw.write(String.format("%.2f",distSum) + "\n");
        bw.flush();
    }

    private static double calDist(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2));
    }

    static int find(int u){
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }
    // 우선순위 : b
    static void union(int a, int b){
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

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Edge implements Comparable<Edge>{
        int start,end;
        double dist;

        public Edge(int start, int end, double dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        public int compareTo(Edge o){
            return Double.compare(this.dist,o.dist);
        }
    }

}