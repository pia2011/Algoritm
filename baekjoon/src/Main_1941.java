import java.io.*;
import java.util.*;

public class Main_1941{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char board[][];
    static int[] combX;
    static int[] combY;
    static int ans = 0;
    public static void main(String[] args) throws Exception{

        board = new char[5][5];
        for(int i = 0; i<5; i++){
            board[i] = br.readLine().toCharArray();
        }

        combX = new int[25];
        combY = new int[25];
        for(int i = 0; i<25; i++){
            combX[i] = i/5; // 행
            combY[i] = i%5; // 열
        }

        combinate(0,0,new int[7], 7);
        System.out.println(ans);

    }

    // idx : 좌표, cnt : 번호, remain : 남은 수
    private static void combinate(int cnt, int idx, int combination[], int remain) {
        if(remain == 0){ // 성립 조건
            bfs(combination);
            return;
        }

        // 탐색범위 넘어가면 모두 종료
        if(idx == 25) return;

        combination[cnt] = idx;
        combinate(cnt+1,idx+1,combination,remain - 1);
        combinate(cnt,idx+1,combination, remain);
    }

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static void bfs(int combination[]){

        Queue<Integer> q = new LinkedList<>();
        q.add(combination[0]);
        boolean visited[] = new boolean[7];
        visited[0] = true;
        int cnt = 1;
        int cntS = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            if(board[combX[now]][combY[now]] == 'S') cntS++;

            for(int i = 0; i<4; i++){ // 4방향 탐색
                int nx = combX[now] + dx[i];
                int ny = combY[now] + dy[i];
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                for(int j = 1; j<=6; j++){
                   if(visited[j]) continue;
                   if(nx != combX[combination[j]]) continue;
                   if(ny != combY[combination[j]]) continue;

                   visited[j] = true;
                   q.add(combination[j]);
                   cnt++;
                }
            }
        }

        // 조건에 맞는지 : 연결되어 있고, S가 더 많음(>=4)
        if(cnt == 7 && cntS >= 4){
            ans++;
        }
    }
}
