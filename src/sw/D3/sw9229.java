package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw9229 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] snack = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                snack[i] = Integer.parseInt(st.nextToken());
            }

            int max = -1;
            int left = 0;
            int right = N - 1;


            Arrays.sort(snack);
            while (left < right) {
                int sum = snack[left] + snack[right];
                if (sum > M) {
                    right--;
                } else {
                    max = Math.max(max, sum);
                    left++;
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }

}
