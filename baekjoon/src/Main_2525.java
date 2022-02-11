import java.io.*;
import java.util.*;

public class Main_2525{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        int need_h = c/60;
        int need_m = c%60;

        h = (h+need_h+(need_m+m)/60)%24;
        m = (m+need_m)%60;

        System.out.println(h+" "+m);

    }
}