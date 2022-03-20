import java.io.*;
import java.util.*;

public class Main_20291{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    public static void main(String[] args) throws Exception{


        n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> etsToCnt = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String[] s = br.readLine().split("\\.");
            if(!etsToCnt.containsKey(s[1])) list.add(s[1]);
            etsToCnt.compute(s[1], (k,v) -> v == null ? 1 : ++v);
        }

        Collections.sort(list);
        for(String s : list){
            bw.write(s +" "+etsToCnt.get(s)+"\n");
        }
        bw.flush();



    }
}
