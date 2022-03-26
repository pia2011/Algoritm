import java.io.*;
import java.util.*;

public class Main_9342{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        int n = Integer.parseInt(br.readLine());
        String regex = "^[A-F]?A+F+C+[A-F]?$";
        for(int i = 0; i<n; i++){
            if(br.readLine().matches(regex)){
                bw.write("Infected!\n");
            }else{
                bw.write("Good\n");
            }
        }
        bw.flush();
    }
}