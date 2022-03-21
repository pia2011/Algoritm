import java.io.*;
import java.util.*;

public class Main_15873{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        String input = br.readLine();
        // 두 수가 주진다.
        if(input.length() == 4){ // 1010
            System.out.println(20);
        }else if(input.length() == 3){ // "10" + 1 ~ 9 or 1 ~ 9 + "10"
            if(input.charAt(1) == '0') // 앞에 나올 경우
                System.out.println(10 + input.charAt(2) - '0');
            else if(input.charAt(2) == '0')
                System.out.println(input.charAt(0) - '0' + 10);
        }else if(input.length() == 2){ // 11 ~ 99
            System.out.println(input.charAt(0) - '0' + input.charAt(1) - '0');
        }

    }
}