import java.io.*;
import java.util.*;

public class Main_1439{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        String input = br.readLine();
        System.out.println(Math.min(new StringTokenizer(input, "0").countTokens(), new StringTokenizer(input, "1").countTokens()));
    }
}