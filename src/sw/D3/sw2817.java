package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2817 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N, K;
    static int[] nums;
    static int sum;
    static int result;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            result = 0;
            sum = 0;
            DFS(0);

            System.out.println("#" + tc + " " + result);
        }
    }

    static void DFS(int c) {
        if (sum == K) {
            result++;
            return;
        }

        for (int i = c; i < nums.length; i++) {
            sum += nums[i];
            DFS(i + 1);
            sum -= nums[i];
        }
    }
}