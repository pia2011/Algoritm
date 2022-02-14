import java.io.*;
import java.util.*;

public class Main_13305{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static long dist[];
    static long price[];
    public static void main(String[] args) throws Exception{

        n = Integer.parseInt(br.readLine());
        dist = new long[n-1];
        price = new long[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n-1; i++){
            dist[i] = Long.parseLong(st.nextToken());

        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n-1; i++){
            price[i] = Long.parseLong(st.nextToken());
        }

        Info info[] = new Info[n-1];
        for(int i = 0; i<n-1; i++){
            info[i] = new Info(dist[i], price[i]);
        }

        long minPrice = price[0];
        long totalPrice = 0L;

        for(int i = 0; i<n-1; i++){

            if(info[i].price < minPrice){
                minPrice = info[i].price;
            }

            totalPrice += minPrice * info[i].dist;
        }

        System.out.println(totalPrice);
    }
    static class Info {
        long dist;
        long price;

        public Info(long dist, long price) {
            this.dist = dist;
            this.price = price;
        }


    }
}
