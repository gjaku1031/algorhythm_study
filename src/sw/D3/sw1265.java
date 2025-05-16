package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1265 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N, P;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            int base = N / P;
            int rest = N % P;
            int[] nums = new int[P];
            for (int i = 0; i < P; i++) {
                nums[i]=base;
            }

            for (int i = 0; rest > 0; i++) {
                nums[i]++;
                rest--;
            }

            long result = 1;
            for (int i : nums) {
                result *= i;
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
