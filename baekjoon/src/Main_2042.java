import java.io.*;
import java.util.*;

public class Main_2042{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m,k;
    static long arr[];
    static long tree[];
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n+1];

        for(int i = 1; i<=n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[4*n];

        init(1,n,1);

        for(int i = 0; i<k+m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                long dif = c - arr[b];
                arr[b] = c;
                update(1,n,1,b,dif);
            }else{
                bw.write(sum(1,n,1,b,(int) c)+"\n");
            }
        }
        bw.flush();
    }

    private static long sum(int start, int end, int node, int left, int right){
        if(left > end || right < start) return 0;
        if(left <= start && end <= right) return tree[node];

        int mid = (start + end)/2;
        long leftSum = sum(start, mid, node*2, left, right);
        long rightSum = sum(mid+1, end, node*2+1, left, right);
        return leftSum + rightSum;
    }

    private static void update(int start, int end, int node, int idx, long dif) {
        if(idx < start || idx > end) return;
        tree[node] += dif;
        if(start == end) return;

        int mid = (start + end)/2;
        update(start, mid,node * 2,idx,dif);
        update(mid + 1, end,node * 2 + 1,idx,dif);
    }

    private static long init(int start, int end, int node) {
        if(start == end) return tree[node] = arr[start];

        int mid = (start + end)/2;
        long leftSum = init(start, mid, node*2);
        long rightSum = init(mid + 1, end, node *  2 + 1);
        return tree[node] = leftSum + rightSum;
    }
}