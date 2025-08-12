package baek.silver.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static int[] dp = new int[12];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int a = Integer.parseInt(br.readLine());
            sb.append(dp[a]).append("\n");
        }
        System.out.println(sb);

    }

}
