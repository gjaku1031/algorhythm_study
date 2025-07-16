package baek.bronze.B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj30999 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int result = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int count = 0;

            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'O') {
                    count++;
                }
            }

            if (count > M / 2) {
                result++;
            }
        }

        System.out.println(result);
    }
}