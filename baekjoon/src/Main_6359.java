import java.io.*;
import java.util.*;

public class Main_6359{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean open[];
    static int n;
    public static void main(String[] args) throws Exception{

        int T = Integer.parseInt(br.readLine());

        while(T-->0){

            n = Integer.parseInt(br.readLine());
            open = new boolean[n+1];

            for(int i = 1; i<=n; i++){
                openOrclose(i);
            }
            int ans = 0;
            for(int i = 1; i<=n; i++){
                if(open[i]) ans++;
            }
            bw.write(ans+"\n");
        }
        bw.flush();


    }

    private static void openOrclose(int x) {

        int next = x;
        while(next <= n){
            open[next] = !open[next];
            next += x;
        }

    }
}