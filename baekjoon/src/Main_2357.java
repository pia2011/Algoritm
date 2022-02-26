import java.io.*;
import java.util.*;

public class Main_2357{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int minTree[];
    static int maxTree[];
    static int arr[];
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        minTree = new int[4*n];
        maxTree = new int[4*n];

        for(int i = 1; i<=n; i++){
             arr[i] = Integer.parseInt(br.readLine());
        }

        maxInit(1,n,1);
        minInit(1,n,1);

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(minFind(1,n,1,a,b) +" "+ maxFind(1,n,1,a,b)+"\n");
        }
        bw.flush();
    }

    private static int minInit(int start, int end, int node) {
        if(start == end) return minTree[node] = arr[start];

        int mid = (start + end)/2;
        int leftMin = minInit(start, mid, node * 2);
        int rightMin = minInit(mid+1, end, node * 2 + 1);
        return minTree[node] = Math.min(leftMin, rightMin);
    }

    private static int maxInit(int start, int end, int node) {
        if(start == end) return maxTree[node] = arr[start];

        int mid = (start + end)/2;
        int leftMax = maxInit(start, mid, node*2);
        int rightMax = maxInit(mid + 1, end, node*2 + 1);
        return maxTree[node] = Math.max(leftMax, rightMax);

    }

    private static int minFind(int start, int end, int node, int left, int right){
        if(end < left || start > right) return Integer.MAX_VALUE;
        if(left <= start && end <= right) return minTree[node];

        int mid = (start + end)/2;
        int leftMin = minFind(start, mid, node*2, left, right);
        int rightMin = minFind(mid + 1, end, node*2+1, left, right);
        return Math.min(leftMin, rightMin);

    }

    private static int maxFind(int start, int end, int node, int left, int right){
        if(end < left || start > right) return Integer.MIN_VALUE;
        if(left <= start && end <= right) return maxTree[node];

        int mid = (start + end)/2;
        int leftMax = maxFind(start, mid, node*2, left, right);
        int rightMax = maxFind(mid + 1, end, node*2+1, left, right);
        return Math.max(leftMax, rightMax);
    }

}