package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11054 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr1;
    static int[] arr2;
    static int[][] dp;
    static int[] result;


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr1 = new int[N + 1];
        arr2 = new int[N + 1];
        result = new int[N + 1];
        dp = new int[2][N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr1[i] = a;
            arr2[N - i + 1] = a;
        }

        for (int i = 1; i <= N; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr1[i] > arr1[j]) {
                    dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
                }
                if (arr2[i] > arr2[j]) {
                    dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            result[i] = dp[0][i] + dp[1][N - i + 1] - 1;
        }

        Arrays.sort(result);
        System.out.println(result[N]);
    }
}