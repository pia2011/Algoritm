import java.io.*;
import java.util.*;

public class Main_16724{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int parent[];
    static int rank[];
    static int n,m;
    static char[][] board;
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rank = new int[n*m];
        parent = new int[n*m];
        board = new char[n][m];

        for(int i = 0; i<parent.length; i++){
            parent[i] = i;
        }
        for(int i = 0; i<n; i++){
            board[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int cvN = i*m + j;
                switch (board[i][j]){
                    case'D':
                        union(cvN, (i+1)*m + j);
                        break;
                    case'U':
                        union(cvN, (i-1)*m + j);
                        break;
                    case'L':

                        union(cvN, i*m + j-1);
                        break;
                    case'R':
                        union(cvN, i*m + j+1);
                        break;
                }
            }
        }

        // 중복 제거
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i<n*m; i++){
            hs.add(find(i));
        }
        bw.write(hs.size()+"\n");
        bw.flush();
    }

    // 항상 b에 이어붙임
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

    static int find(int u){
        if(u == parent[u]) return u;
        return parent[u] = find(parent[u]); // 최적화(모두 루트를 가르키도록 최신화)
    }
}
