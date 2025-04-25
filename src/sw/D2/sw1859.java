package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1859 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int count = 1; count <= T; count++) {
            int N = Integer.parseInt(br.readLine());
            long totalProfit = 0;
            int[] prices = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            int maxPrice = prices[N - 1];

            for (int i = N - 2; i >= 0; i--) {
                if (prices[i] < maxPrice) {
                    totalProfit += maxPrice - prices[i];
                } else {
                    maxPrice = prices[i];
                }
            }

            System.out.println("#" + count + " " + totalProfit);
        }
    }
}