import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main_23291{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,k;
    static int fishes[][];
    public static void main(String[] args) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        fishes = new int[n][n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            fishes[n-1][i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        do{
            addFish();
            firstFold();
            controlFish();
            spread();
            secondFold();
            controlFish();
            spread();
            cnt++;
        }while(k < count());

        System.out.println(cnt);
    }

    private static int count() {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(fishes[i][j] == 0) continue;

                max = Math.max(max, fishes[i][j]);
                min = Math.min(min, fishes[i][j]);

            }
        }

        return Math.abs(max - min);
    }

    private static void secondFold() {

        for(int i = 0; i<n/2; i++){
            fishes[n-2][n-1-i] = fishes[n-1][i];
            fishes[n-1][i] = 0;
        }

        // 문제 발생
        for(int i = n-1; i>n-3; i--){
            for(int j = n/2; j< n/2+n/4; j++){
                int nr = n-4 + (n-1-i);
                int nc = n-1 - (j-n/2);

                fishes[nr][nc] = fishes[i][j];
                fishes[i][j] = 0;
            }
        }

    }



    private static void spread() {

        int temp[] = new int[n];
        int cnt = 0;
        for(int j = 0; j<n; j++){
            for(int i = n-1; i>=0; i--){
                if(fishes[i][j] == 0) continue;
                temp[cnt++] = fishes[i][j];
                fishes[i][j] = 0;
            }
        }

        for(int i = 0; i<n; i++){
            fishes[n-1][i] = temp[i];
        }

    }

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    private static void controlFish() {

        int temp[][] = new int[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(fishes[i][j] != 0){
                    for(int k = 0; k<4; k++){
                        int nx = dx[k] + i;
                        int ny = dy[k] + j;
                        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if(fishes[nx][ny] == 0) continue;

                        int sub = fishes[i][j] - fishes[nx][ny];
                        if(sub >= 5){
                            int d = sub/5;
                            temp[i][j] -= d;
                            temp[nx][ny] += d;
                        }

                    }
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(temp[i][j] != 0)
                    fishes[i][j] += temp[i][j];
            }
        }
    }

    private static void firstFold() {
        int startC = 0; // 열
        int w = 1;
        int h = 1;
        while(startC + w + h <= n){

            for(int i = n - 1; i>n - 1 - h; i--){
                for(int j = startC; j<startC + w; j++){

                    int nc = w + startC + (n-1-i);
                    int nr = n - 1 - w  + (j-startC);

                    fishes[nr][nc] = fishes[i][j];
                    fishes[i][j] = 0;
                }
            }

//            print();

            startC += w;
            if(h == w) h++;
            else w ++;
        }
    }

    private static void addFish() {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            min = Math.min(min, fishes[n-1][i]);
        }

        for(int i = 0; i<n; i++){
            if(fishes[n-1][i] == min){
                fishes[n-1][i]++;
            }
        }
    }

    private static void print(){
        for(int i = 0; i<n; i++){
            for(int j= 0; j<n; j++){
                System.out.print(fishes[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
