import java.io.*;
import java.util.*;

public class Main_14469{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        int n = Integer.parseInt(br.readLine());
        Cow cows[] = new Cow[n];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arriveTime = Integer.parseInt(st.nextToken());
            int checkTime = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(arriveTime, checkTime);
        }

        int nextTime = 0;
        Arrays.sort(cows);
        for(Cow cow : cows){
            if(cow.arriveTime >= nextTime){
                nextTime = cow.arriveTime + cow.checkTime;
            }else{
                nextTime = nextTime + cow.checkTime;
            }

        }
        System.out.println(nextTime);


    }
    static class Cow implements Comparable<Cow>{
        int arriveTime, checkTime;

        public Cow(int arriveTime, int checkTime) {
            this.arriveTime = arriveTime;
            this.checkTime = checkTime;
        }

        @Override
        public int compareTo(Cow o) {
            return this.arriveTime - o.arriveTime;
        }

    }

}