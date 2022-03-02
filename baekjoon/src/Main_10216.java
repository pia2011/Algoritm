import java.io.*;
import java.util.*;

public class Main_10216{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int arr[][];
    static int parent[];
    static int rank[];
    public static void main(String[] args) throws Exception{

        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][3];
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());

                parent[i] = i;
            }

            for(int i = 0; i<n; i++){
                for(int j = i + 1; j<n; j++){

                    int dist_x = Math.abs(arr[i][0] - arr[j][0]);
                    int dist_y = Math.abs(arr[i][1] - arr[j][1]);
                    int sum_r = Math.abs(arr[i][2] + arr[j][2]);

                    // 두 기지의 통신범위가 겹치면
                    if(isAvailableToCommunicate(dist_x, dist_y, sum_r)) union(i,j);
                }
            }
            bw.write(findAllGroup()+"\n");
        }
        bw.flush();

    }

    private static int findAllGroup() {

        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i<n; i++){
            hs.add(find(i));
        }
        return hs.size();
    }

    private static boolean isAvailableToCommunicate(int dist_x, int dist_y, int sum_r) {
        int powDist = (int)Math.pow(dist_x,2) + (int)Math.pow(dist_y,2);
        if(powDist <= Math.pow(sum_r,2)) return true;
        else return false;
    }

    static int find(int u){
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]); // 최적화
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return;
        if(rank[a] > rank[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        parent[a] = b;
        if(rank[a] == rank[b]) ++rank[b];
    }
}