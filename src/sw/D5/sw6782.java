package sw.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw6782 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            long N = Long.parseLong(br.readLine());
            if (N == 1) {
                count = 1;
            } else {
                count = 0;
                while (N != 2) {
                    long pre = (long) Math.sqrt(N);
                    if (Math.pow(pre, 2) == N) {
                        count++;
                        N = pre;
                    } else {
                        long next = (long) Math.pow(pre + 1, 2);
                        count += next - N;
                        N = next;
                    }
                }

            }
            System.out.println("#" + tc + " " + count);

        }
    }
}
