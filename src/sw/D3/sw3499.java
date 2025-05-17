package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw3499 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String[] cards = new String[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cards[i] = st.nextToken();
            }

            System.out.print("#" + tc + " ");
            int half = (N + 1) / 2;
            for (int i = 0; i < half; i++) {
                System.out.print(cards[i] + " ");
                if (i + half < N) {
                    System.out.print(cards[i + half] + " ");
                }
            }
            System.out.println();
        }
    }
}