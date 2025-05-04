package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class bj2579 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] stair = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stair[1];
        if (N == 1) {
            System.out.println(dp[1]);
            return;
        }

        dp[2] = stair[1] + stair[2];
        if (N == 2) {
            System.out.println(dp[2]);
            return;
        }

        dp[3] = max(stair[1] + stair[3], stair[2] + stair[3]);
        if (N == 3) {
            System.out.println(dp[3]);
            return;
        }


        for (int i = 4; i <= N; i++) {
            dp[i] = max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
        }

        System.out.println(dp[N]);
    }
}