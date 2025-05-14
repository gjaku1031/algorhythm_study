package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw3282 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N, K;
    static int[] dp;

    static int[] volume;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            volume = new int[N+1];
            cost = new int[N+1];
            dp = new int[K + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                volume[i] = Integer.parseInt(st.nextToken());
                cost[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                for (int j = K; j - volume[i] >= 0; j--) {
                    dp[j] = Math.max(dp[j], dp[j - volume[i]] + cost[i]);
                }
            }

            Arrays.sort(dp);
            System.out.println("#" + tc + " " + dp[K]);
        }
    }
}