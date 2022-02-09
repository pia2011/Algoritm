import java.io.*;
import java.util.*;

public class Main_5014{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, from, to, up, down;
    static int ans = Integer.MAX_VALUE;
    static boolean visited[];
    public static void main(String[] args) throws Exception{

        String input[] = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        from = Integer.parseInt(input[1]);
        to = Integer.parseInt(input[2]);
        up = Integer.parseInt(input[3]);
        down = Integer.parseInt(input[4]);

        visited = new boolean[n+1];

        bfs(from);
        System.out.println(ans == Integer.MAX_VALUE ? "use the stairs" : ans);

    }

    private static void bfs(int from) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(from,0));
        while(!q.isEmpty()){
            Info now = q.poll();
            if(now.floor == to){
                ans = Math.min(ans, now.cnt);
            }

            if(now.floor <= 0 || now.floor > n) continue;
            if(visited[now.floor]) continue;
            visited[now.floor] = true;

            q.add(new Info(now.floor + up,now.cnt + 1));
            q.add(new Info(now.floor - down,now.cnt + 1));

        }
    }

    static class Info{
        int floor, cnt;

        public Info(int floor, int cnt) {
            this.floor = floor;
            this.cnt = cnt;
        }
    }
}