package baek.step.dp1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1912 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> list = new ArrayList<>();
    static StringTokenizer st;
    static int[] arr;
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        dp[0] = arr[0];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }
        System.out.println(dp[n - 1]);
    }
}