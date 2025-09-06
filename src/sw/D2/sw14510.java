package sw.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw14510 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());

            long[] h = new long[N];
            long M = 0;
            int idx = 0;

            while (idx < N) {
                String line = br.readLine();
                if (line == null) break;
                if (line.isEmpty()) continue;

                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens() && idx < N) {
                    h[idx] = Long.parseLong(st.nextToken());
                    if (h[idx] > M) M = h[idx];
                    idx++;
                }
            }

            long odd = 0;
            long even = 0;
            for (int i = 0; i < N; i++) {
                long diff = M - h[i];
                odd  += diff % 2;
                even += diff / 2;
            }

            while (even - odd > 1) {
                even--;
                odd += 2;
            }

            long ans = Math.max(even * 2, odd * 2 - 1);
            if (ans < 0) ans = 0;

            out.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.print(out.toString());
    }
}