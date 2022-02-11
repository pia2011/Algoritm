import java.io.*;
import java.util.*;

public class Main_1009{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int ans = 1;
            for(int i = 0; i<b; i++){
                ans = (ans * a)%10;
            }
            if(ans == 0) ans = 10;

            bw.write(ans+"\n");
        }
        bw.flush();


    }
}