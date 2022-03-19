import java.io.*;
import java.util.*;

public class Main_11478{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashSet<String> hs;
    public static void main(String[] args) throws Exception{

        hs = new HashSet<>();
        String input = br.readLine();
        // 모든 경우의 수 고려
        for(int i = 0; i<input.length(); i++){
            for(int j = i + 1; j<=input.length(); j++){
                hs.add(input.substring(i,j));
            }
        }

        System.out.println(hs.size());
    }
}