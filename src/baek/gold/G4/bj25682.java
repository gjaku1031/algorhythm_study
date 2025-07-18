package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj25682 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static String[] chess1;
    static String[] chess2;

    static String[] input;
    static int[][] sum1;
    static int[][] sum2;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        initChess();

        input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        sum1 = new int[N + 1][M + 1];
        sum2 = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int diff1 = (input[i - 1].charAt(j - 1) != chess1[i - 1].charAt(j - 1)) ? 1 : 0;
                int diff2 = (input[i - 1].charAt(j - 1) != chess2[i - 1].charAt(j - 1)) ? 1 : 0;

                sum1[i][j] = sum1[i - 1][j] + sum1[i][j - 1] - sum1[i - 1][j - 1] + diff1;
                sum2[i][j] = sum2[i - 1][j] + sum2[i][j - 1] - sum2[i - 1][j - 1] + diff2;
            }
        }
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                int result1 = sum1[i + K - 1][j + K - 1] - sum1[i - 1][j + K - 1] - sum1[i + K - 1][j - 1] + sum1[i - 1][j - 1];
                int result2 = sum2[i + K - 1][j + K - 1] - sum2[i - 1][j + K - 1] - sum2[i + K - 1][j - 1] + sum2[i - 1][j - 1];
                min1 = Math.min(min1, result1);
                min2 = Math.min(min2, result2);
            }
        }
        System.out.println(Math.min(min1, min2));

    }

    static void initChess() {
        String line1;
        String line2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (i % 2 == 0) {
                sb.append("W");
            } else {
                sb.append("B");
            }
        }

        line1 = sb.toString();
        sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (i % 2 == 0) {
                sb.append("B");
            } else {
                sb.append("W");
            }
        }
        line2 = sb.toString();

        chess1 = new String[N];
        chess2 = new String[N];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                chess1[i] = line1;
                chess2[i] = line2;
            } else {
                chess1[i] = line2;
                chess2[i] = line1;
            }
        }
    }
}
