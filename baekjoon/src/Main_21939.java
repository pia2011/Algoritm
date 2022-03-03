import java.io.*;
import java.util.*;

public class Main_21939{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int searchHard[];
    static int remove[];
    public static void main(String[] args) throws Exception{

        n = Integer.parseInt(br.readLine());
        searchHard = new int[100001]; // ID로 난이도를 찾음
        remove = new int[100001];
        PriorityQueue<Problem> pq = new PriorityQueue<>();
        PriorityQueue<Problem2> pq_reverse = new PriorityQueue<>();
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int hard = Integer.parseInt(st.nextToken());

            pq.add(new Problem(idx, hard));
            pq_reverse.add(new Problem2(idx, hard));

            searchHard[idx] = hard;
        }
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("add")){ // 추가

                int idx = Integer.parseInt(st.nextToken());
                int hard = Integer.parseInt(st.nextToken());

                pq.add(new Problem(idx, hard));
                pq_reverse.add(new Problem2(idx, hard));

                searchHard[idx] = hard;

            }else if(cmd.equals("recommend")){ // 출력
                int cmdIdx = Integer.parseInt(st.nextToken());
                if(cmdIdx == 1){
                    while(remove[pq.peek().idx] == pq.peek().hard){
                        pq.poll();
                    }
                    bw.write(pq.peek().idx+"\n");

                }else if(cmdIdx == -1){
                    while(remove[pq_reverse.peek().idx] == pq_reverse.peek().hard){
                        pq_reverse.poll();
                    }
                    bw.write(pq_reverse.peek().idx+"\n");

                }
            }else if(cmd.equals("solved")){ // 제거
                int idx = Integer.parseInt(st.nextToken());
                // 이미 searchId에는 최신화된 난이도가 적혀있음. 해당 난이도를 지우라고 적어둠
                remove[idx] = searchHard[idx];
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

    // 쉬운 문제부터 뽑음
    static class Problem2 implements Comparable<Problem2>{
        int idx, hard;

        public Problem2(int idx, int hard) {
            this.idx = idx;
            this.hard = hard;
        }

        public int compareTo(Problem2 o){
            if(this.hard == o.hard){
                return this.idx - o.idx;
            }
            return this.hard - o.hard;
        }
    }
}
