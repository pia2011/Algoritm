import java.io.*;
import java.util.*;

public class Main_5582{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        String a = br.readLine();
        String b = br.readLine();

        int[][] lcs = new int[a.length() + 1][b.length() + 1];

        int ans = 0;
        for(int i = 1; i<=a.length(); i++){
            for(int j = 1; j<=b.length(); j++){
                if(a.charAt(i - 1) == b.charAt(j - 1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                    ans = Math.max(ans, lcs[i][j]);
                }
            }
        }

        System.out.println(ans);
    }
}