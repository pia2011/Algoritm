import java.io.*;
import java.util.*;

public class Main_10804{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        int []arr = new int[21];
        for(int i = 1; i<=20 ; i++){
            arr[i] = i;
        }

        for(int i = 0; i<10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            reverseOrder(arr, from, to);

        }

        for(int i = 1; i<=20; i++){
            bw.write(arr[i]+" ");
        }
        bw.flush();

    }
    static void reverseOrder(int[] target ,int from, int to){

        int copy[] = new int[to-from+1];

        // 거꾸로 담기
        for(int i = 0; i<copy.length; i++){
            copy[i] = target[to-i];
        }

        // 복사 하기
        for(int i = 0; i<copy.length; i++){
            target[from+i] = copy[i];
        }
    }
}