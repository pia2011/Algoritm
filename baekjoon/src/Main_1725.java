import java.io.*;
import java.util.*;

public class Main_1725{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int treeMin[];
    static int arr[];
    static int n;
    public static void main(String[] args) throws Exception{

        // 세그먼트 트리 : 구간 최소 높이
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        treeMin = new int[4 * n];
        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        initMin(1,n,1);
        System.out.println(findMax(1,n));
    }

    // idx
    private static int initMin(int start, int end, int node) {
        if(start == end) return treeMin[node] = start;

        int mid = (start + end)/2;
        int leftMin = initMin(start, mid, node * 2);
        int rightMin = initMin(mid + 1, end, node * 2 + 1);

        return treeMin[node] = arr[leftMin] < arr[rightMin] ? leftMin : rightMin;
    }

    // idx
    private static int findMinIdx(int start, int end, int node, int left, int right) {
        if(start > right || end < left) return Integer.MAX_VALUE;// 무효값
        if(left <= start && end <= right) return treeMin[node];

        int mid = (start + end)/2;

        int leftMin = findMinIdx(start, mid, node * 2, left, right);
        int rightMin = findMinIdx(mid + 1, end, node * 2 + 1, left, right);

        // 사전에 통제 : INF값을 처리할 수 없음
        if(leftMin == Integer.MAX_VALUE) return rightMin;
        else if(rightMin == Integer.MAX_VALUE) return leftMin;
        else return arr[leftMin] < arr[rightMin] ? leftMin : rightMin;
    }

    private static int findMax(int start, int end) {

        int midIdx = findMinIdx(1, n, 1, start, end);
        int maxArea = (end - start + 1) * arr[midIdx];

        if(start < midIdx)
            maxArea = Math.max(maxArea, findMax(start, midIdx - 1));
        if(midIdx < end)
            maxArea = Math.max(maxArea, findMax(midIdx + 1, end));

        return maxArea;
    }

}