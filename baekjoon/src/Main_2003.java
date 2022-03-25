import java.io.*;
import java.util.*;

public class Main_2003{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int arr[];
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = 0;
        while(true){

            if(sum >= m){ // 같거나 많으면 범위를 좁혀줌
                sum -= arr[start++];
            }else if(end == n){ // 다음에 더 진행하면 error 발생
                break;
            }else{ // 적으면 범위를 넓혀줌
                sum += arr[end++];
            }

            if(sum == m) ans++;

        }

        System.out.println(ans);

    }
}
