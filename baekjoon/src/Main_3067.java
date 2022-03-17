import java.io.*;
import java.util.*;

public class Main_3067 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int amount[];
    public static void main(String[] args) throws Exception{

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            n = Integer.parseInt(br.readLine());
            amount = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<n; i++){
                amount[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            sb.append(findCases(m)+"\n");
        }

        System.out.println(sb.toString());
    }

    private static int findCases(int target) {
        int dp[] = new int[10001];
        dp[0] = 1;
        for(int i = 0; i<n; i++){
            for(int j = amount[i]; j<=target; j++){
                dp[j] += dp[j - amount[i]];
            }
        }

        return dp[target];
    }
}