package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw3307 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int[] nums;
    static int[] dp;
    static int result;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            nums = new int[N];
            dp = new int[N];
            result = 1;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
                result = Math.max(result, dp[i]);
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
