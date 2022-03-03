import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_21939_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static TreeSet<Problem> ts;
    static HashMap<Integer, Integer> hm;
    public static void main(String[] args) throws Exception{

        n = Integer.parseInt(br.readLine());
        ts = new TreeSet<>();
        hm = new HashMap<>();

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int hard = Integer.parseInt(st.nextToken());

            ts.add(new Problem(idx, hard));
            hm.put(idx, hard);
        }
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("add")){ // 추가

                int idx = Integer.parseInt(st.nextToken());
                int hard = Integer.parseInt(st.nextToken());

                ts.add(new Problem(idx, hard));
                hm.put(idx, hard);

            }else if(cmd.equals("recommend")){ // 출력
                int cmdIdx = Integer.parseInt(st.nextToken());
                if(cmdIdx == 1){
                    bw.write(ts.first().idx+"\n");
                }else if(cmdIdx == -1){
                    bw.write(ts.last().idx+"\n");
                }
            }else if(cmd.equals("solved")){ // 제거
                int idx = Integer.parseInt(st.nextToken());
                ts.remove(new Problem(idx, hm.get(idx)));
                hm.remove(idx);
            }
        }
        bw.flush();
    }

    // 어려운 문제부터 뽑음
    static class Problem implements Comparable<Problem>{
        int idx, hard;

        public Problem(int idx, int hard) {
            this.idx = idx;
            this.hard = hard;
        }

        public int compareTo(Problem o){
            if(o.hard == this.hard){
                return o.idx - this.idx;
            }
            return o.hard - this.hard;
        }
    }
}
