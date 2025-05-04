package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1932 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] triangle;
    static int[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        triangle = new int[N][N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0] = triangle[0][0];
        
        for (int i = 1; i < N; i++) {
            for (int j = i; j >= 0; j--) {
                int currentVal = triangle[i][j];
                if (j == i) {
                    dp[j] = dp[j - 1] + currentVal;
                } else if (j == 0) {
                    dp[j] = dp[j] + currentVal;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]) + currentVal;
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}