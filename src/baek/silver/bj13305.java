package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13305 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    static long[] length;
    static long[] price;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        length = new long[N - 1];
        price = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            length[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long best = price[0];

        for (int i = 0; i < N - 1; i++) {
            if (price[i] < best) {
                best = price[i];
            }
            sum += best * length[i];
        }

        System.out.println(sum);
    }
}
