import java.io.*;
import java.util.*;

public class Main_11659_2{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int arr[];
    static int n,m;
    static int treeSum[];
    public static void main(String[] args) throws Exception{

        // 세그먼트 트리 이용해서 구간합 구해보기
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        treeSum = new int[4 * n];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initSum(1,n,1);

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            bw.write(findSum(1,n,1,from , to)+"\n");
        }

        bw.flush();

    }
    private static int initSum(int start, int end, int node){
        if(start == end) return treeSum[node] = arr[start];

        int mid = (start + end)/2;
        int leftSum = initSum(start, mid, 2 * node);
        int rightSum = initSum(mid + 1, end, 2 * node + 1);
        return treeSum[node] = leftSum + rightSum;
    }

    private static int findSum(int start, int end, int node, int left, int right){
        if(end < left || right < start) return 0;
        if(left <= start && end <= right) return treeSum[node];

        int mid = (start + end)/2;
        int leftSum = findSum(start, mid, node * 2, left, right);
        int rightSum = findSum(mid + 1, end, node * 2 + 1, left, right);
        return leftSum + rightSum;
    }
}