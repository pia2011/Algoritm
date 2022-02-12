import java.io.*;
import java.util.*;

public class Main_1005{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,k;
    static ArrayList<Integer> adj[];
    static int cntLink[];
    static int timeToBuild[];
    public static void main(String[] args) throws Exception{

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            cntLink = new int[n+1];
            timeToBuild = new int[n+1];
            result = new int[n+1];
            adj = new ArrayList[n+1];
            for(int i = 1; i<=n; i++){
                adj[i] = new ArrayList<>();
            }

            // 시간
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i<=n; i++){
                timeToBuild[i] = Integer.parseInt(st.nextToken());
            }

            // 관계
            for(int i = 0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a].add(b); // a에 b를 연결 : b를 위해 a가 필요
                cntLink[b]++; // 선행 정점의 개수++
            }

            topologicalSort();

            int target = Integer.parseInt(br.readLine());
            bw.write(result[target]+"\n");

        }
        bw.flush();

    }

    static int result[];
    private static void topologicalSort() {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 초기화 시켜주면서.. 시작점 찾기
        for(int i = 1; i<=n; i++){
            result[i] = timeToBuild[i];

            if(cntLink[i] == 0)
                pq.add(i);
        }

        // 순서 정하기
        while(!pq.isEmpty()){
            int now = pq.poll();

            for(int next : adj[now]){
                result[next] = Math.max(result[next], result[now]+timeToBuild[next]);

                cntLink[next]--;

                // 건물을 지을 수 있게 되면
                if(cntLink[next] == 0)
                    pq.add(next);
            }
        }

    }

}