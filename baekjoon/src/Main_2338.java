import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main_2338{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());


        bw.write(a.add(b)+"\n"+a.subtract(b)+"\n"+a.multiply(b)+"\n");

        bw.flush();
    }
}