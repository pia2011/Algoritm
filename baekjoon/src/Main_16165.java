import java.io.*;
import java.util.*;

public class Main_16165{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashMap<String, String> nameToGroup = new HashMap<>();
        HashMap<String, ArrayList> groupToNames = new HashMap<>();

        for(int i = 0; i<n; i++){
            String groupName = br.readLine();
            int num = Integer.parseInt(br.readLine());

            ArrayList<String> list = new ArrayList<>();
            for(int j = 0; j<num; j++){
                String memberName = br.readLine();
                list.add(memberName);
                nameToGroup.put(memberName, groupName);
            }
            Collections.sort(list);
            groupToNames.put(groupName, list);

        }

        for(int i = 0; i<m; i++){
            String cmdS = br.readLine();
            int cmdN = Integer.parseInt(br.readLine());

            if(cmdN == 1){ // 그룹 이름 출력
                bw.write(nameToGroup.get(cmdS)+"\n");
            }else{ // 그룹 멤버들 출력
                ArrayList<String> list = groupToNames.get(cmdS);
                for(String s : list){
                    bw.write(s+"\n");
                }
            }
        }
        bw.flush();

    }
}

