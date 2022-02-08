import java.io.*;
import java.util.*;

public class Main_1547 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean ball[];
    public static void main(String[] args) throws Exception{

        int n = Integer.parseInt(br.readLine());
        ball = new boolean[4];
        ball[1] = true;
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            swap(a,b);
        }

        for(int i = 1; i<=3; i++){
            if(ball[i]){
                System.out.println(i);
            }
        }

    }

    private static void swap(int a, int b) {
        boolean temp;
        temp = ball[a];
        ball[a] = ball[b];
        ball[b] = temp;
    }
}