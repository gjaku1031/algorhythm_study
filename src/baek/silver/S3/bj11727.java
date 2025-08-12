package baek.silver.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11727 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= 1000; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
        }
        int N = Integer.parseInt(br.readLine());
        System.out.println(dp[N]);

    }
}