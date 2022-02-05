import java.io.*;
import java.util.*;

public class Main_1697{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean visited[] = new boolean[100001];
        // 할수 있는 것 : 순간이동 또는 앞으로 걷기 또는 뒤로 걷기
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(n,0));

        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x == k){
                bw.write(now.cnt+"\n");
                bw.flush();
                break;
            }

            int teleport = now.x * 2;
            if(teleport <= 100000 && !visited[teleport]) {
                visited[teleport] = true;
                q.add(new Point(teleport, now.cnt + 1));
            }

            int goForward = now.x + 1;
            if(goForward<= 100000 && !visited[goForward]) {
                visited[goForward] = true;
                q.add(new Point(goForward, now.cnt + 1));
            }

            int goBack = now.x - 1;
            if(goBack >= 0 && !visited[goBack]) {
                visited[goBack] = true;
                q.add(new Point(goBack, now.cnt + 1));
            }

        }

    }
    static class Point{
        int x, cnt;

        public Point(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
