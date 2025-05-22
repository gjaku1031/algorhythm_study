package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj21317 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    static int[][] jump;
    static int[][] dp;

    static final int INF = Integer.MAX_VALUE / 2;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][2];
        jump = new int[N][2];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jump[i - 1][0] = Integer.parseInt(st.nextToken());
            jump[i - 1][1] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], INF);
        }

        if (N >= 1) {
            dp[1][0] = 0;
        }


        for (int i = 2; i <= N; i++) {
            if (i - 1 >= 1 && dp[i - 1][0] != INF) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] + jump[i - 1 - 1][0]);
            }
            if (i - 2 >= 1 && dp[i - 2][0] != INF) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 2][0] + jump[i - 2 - 1][1]);
            }

            if (i - 1 >= 1 && dp[i - 1][1] != INF) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + jump[i - 1 - 1][0]);
            }
            if (i - 2 >= 1 && dp[i - 2][1] != INF) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 2][1] + jump[i - 2 - 1][1]);
            }
            if (i - 3 >= 1 && dp[i - 3][0] != INF) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 3][0] + K);
            }
        }
        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}
