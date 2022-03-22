import java.io.*;
import java.util.*;

public class Main_11659{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sum[] = new int[n + 1];
        for(int i = 1; i<=n; i++){
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            bw.write(sum[to] - sum[from - 1]+"\n");
        }
        bw.flush();

    }
}