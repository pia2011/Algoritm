import java.io.*;
import java.util.*;

public class Main_4803{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int parent[];
    static boolean cycle[];
    static int tc;
    public static void main(String[] args) throws Exception{

        String input;
        while(!(input = br.readLine()).equals("0 0")){
            StringTokenizer st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            ++tc;

            cycle = new boolean[n + 1];

            parent = new int[n + 1];
            for(int i = 1; i<=n; i++){
                parent[i] = i;
            }

            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a,b);
            }

            HashSet<Integer> hs = new HashSet<>();
            for(int i = 1; i<=n; i++){
                int root = find(i);
                if(root != 0)
                    hs.add(find(i));
            }


            bw.write("Case "+tc+": "+printAns(hs.size())+"\n");
        }
        bw.flush();

    }

    private static String printAns(int cnt) {
        if(cnt == 0){
            return "No trees.";
        }else if(cnt == 1){
            return "There is one tree.";
        }else{
            return "A forest of "+cnt+" trees.";
        }
    }

    static int find(int u){
        if(parent[u] == u) return u;
        else return parent[u] = find(parent[u]);
    }
    // 항상 b가 더 크도록
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a > b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        if(a == b) parent[a] = 0; // 상위 노드를 초기화
        else parent[b] = a; // 상위 노드를 물려받음
    }
}