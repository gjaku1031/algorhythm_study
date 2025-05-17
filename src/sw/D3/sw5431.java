package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw5431 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] result = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                int a = Integer.parseInt(st.nextToken());
                result[a - 1] = 1;
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < N; i++) {
                if (result[i] == 0) {
                    System.out.print((i + 1) + " ");
                }
            }
            System.out.println();
        }
    }
}
