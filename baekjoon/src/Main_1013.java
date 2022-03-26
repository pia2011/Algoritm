import java.io.*;
import java.util.*;

public class Main_1013{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        String pattern = "(100+1+|01)+";
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            boolean matches = br.readLine().matches(pattern);
            if(matches){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }
        bw.flush();
    }
}
