import java.io.*;
import java.util.*;

public class Main_1966 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        // 중요도가 같고, 순서도 같으면 끝
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int order = Integer.parseInt(st.nextToken());
            int ans = 1;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Info> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<n; i++){ // 중요도
                int importance = Integer.parseInt(st.nextToken());
                q.add(new Info(importance,i));
                pq.add(importance);
            }

            while(true){
                Info info = q.poll();
                if(info.importance == pq.peek() && info.order == order){
                    bw.write(ans+"\n");
                    break;
                }else if(info.importance == pq.peek()){
                    q.add(info);
                    ans++;
                    pq.poll();
                }else{
                    q.add(info);
                }
            }
        }
        bw.flush();

    }
    static class Info{
        int importance;
        int order;

        public Info(int importance, int order) {
            this.importance = importance;
            this.order = order;
        }
    }
}
