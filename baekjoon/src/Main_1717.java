import java.io.*;
import java.util.*;

public class Main_1717{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int parent[];
    static int rank[];
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int cmdIdx = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(cmdIdx == 0){
                union(a,b);
            }else if(cmdIdx == 1){
                printAns(find(a), find(b));
            }
        }
        bw.flush();


    }

    static void printAns(int rootA, int rootB)throws IOException{
        bw.write(rootA == rootB ? "YES\n" : "NO\n");
    }
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return;
        if(rank[rootA] > rank[rootB]){
            int tmp = rootA;
            rootA = rootB;
            rootB = tmp;
        }
        parent[rootA] = rootB;
        if(rank[rootA] == rank[rootB]) ++rank[rootB];
    }

    static int find(int u){
        if(parent[u] == u) return u;
        else return parent[u] = find(parent[u]); // 재귀사용 최적화
    }
}