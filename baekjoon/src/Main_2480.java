import java.io.*;
import java.util.*;

public class Main_2480{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if(a == b && b == c){
           bw.write(10000 + a * 1000 +"\n");
        }else if(a == b){
            bw.write(1000 + a * 100+"\n");
        }else if(a == c){
            bw.write(1000 + a * 100+"\n");
        }else if(b == c){
            bw.write(1000 + b * 100+"\n");
        }else{
            bw.write(Math.max(Math.max(a,b),c)*100+"\n");
        }
        bw.flush();

    }
}
