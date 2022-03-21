import java.io.*;
import java.util.*;

public class Main_10422{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int l;
    static long d[];
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception{

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int l = Integer.parseInt(br.readLine());
            d = new long[l + 1];

            d[0] =  1;

            // 로직
            for(int i = 2; i<=l; i+=2){
                for(int j = 2; j<=i; j+=2){
                    d[i] += d[j - 2] * d[i - j];
                    d[i] %= MOD;
                }
            }


            bw.write(d[l]+"\n");
        }
        bw.flush();

    }

}