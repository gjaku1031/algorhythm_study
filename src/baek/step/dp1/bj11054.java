package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11054 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[2][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
                }
            }
        }





    }
}
