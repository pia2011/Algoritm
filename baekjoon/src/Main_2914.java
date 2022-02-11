import java.io.*;
import java.util.*;

public class Main_2914{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken());

        System.out.println(a*(i-1)+1);


    }
}