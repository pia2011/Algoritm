import java.io.*;
import java.util.*;

public class Main_2133{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        int n = Integer.parseInt(br.readLine());
        int d[] = new int[n+1];
        if(n>1) d[2] = 3;
        for(int i = 4; i<=n; i++){
            d[i] = d[i-2] * 3;
            for(int j = 2; j < i - 2; j+=2){
                d[i] += d[j] * 2;
            }
            d[i]+=2;
        }

        if(n%2 != 0){
            System.out.println(0);
        }else{
            System.out.println(d[n]);
        }

    }
}