package baek.silver.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        BTC(0, 0);
    }

    static void BTC(int start, int level) {
        if (level == M) {
            System.out.println(sb.toString().trim());
            return;
        }
        for (int i = start; i < N; i++) {
            int originalLength = sb.length();

            sb.append(nums[i]).append(" ");

            BTC(i + 1, level + 1);

            sb.setLength(originalLength);
        }

    }
}
