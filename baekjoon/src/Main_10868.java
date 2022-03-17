import java.io.*;
import java.util.*;

public class Main_10868{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int arr[];
    static int minTree[];
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        minTree = new int[4*n];

        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        minInit(1,n,1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(findMin(1,n,1,a,b)+"\n");
        }
        System.out.println(sb.toString());

    }

    private static int minInit(int start, int end, int node) {

        if(start == end) return minTree[node] = arr[start];

        int mid = (start + end)/2;
        int leftMin = minInit(start, mid, node*2);
        int rightMin = minInit(mid+1, end, node*2 + 1);

        return minTree[node] = Math.min(leftMin, rightMin);
    }

    private static int findMin(int start, int end, int node, int left, int right){
        if(right < start || end < left) return Integer.MAX_VALUE;
        if(left <= start && end <= right) return minTree[node];

        int mid = (start + end)/2;

        int leftMin = findMin(start, mid, node * 2, left, right);
        int rightMin = findMin(mid + 1, end, node * 2 + 1, left, right);

        return Math.min(leftMin, rightMin);
    }

}