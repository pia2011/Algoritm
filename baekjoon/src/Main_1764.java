import java.io.*;
import java.util.*;

public class Main_1764 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    public static void main(String[] args) throws Exception{

       StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());

       HashSet<String> hs = new HashSet<>();
       for(int i = 0; i<n; i++){
           hs.add(br.readLine());
       }

       ArrayList<String> ansList = new ArrayList<>(); // 정렬 필요
       for(int i = 0; i<m; i++){
           String input = br.readLine();
           if(hs.contains(input)){
               ansList.add(input);
           }
       }

       Collections.sort(ansList);
       StringBuilder sb = new StringBuilder();
       sb.append(ansList.size()+"\n");
       for(String s : ansList){
           sb.append(s+"\n");
       }
        System.out.println(sb.toString());
    }

}