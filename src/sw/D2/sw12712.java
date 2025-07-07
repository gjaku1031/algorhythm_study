package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw12712 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static int N, M;
    static int[][] fly;

    static int[] dr_plus = {-1, 1, 0, 0};
    static int[] dc_plus = {0, 0, -1, 1};

    static int[] dr_cross = {-1, 1, 1, -1};
    static int[] dc_cross = {-1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            fly = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    fly[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxFlies = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int plusSum = calculateFlies(i, j, dr_plus, dc_plus);
                    int crossSum = calculateFlies(i, j, dr_cross, dc_cross);
                    maxFlies = Math.max(maxFlies, Math.max(plusSum, crossSum));
                }
            }

            System.out.println("#" + tc + " " + maxFlies);
        }
    }

    private static int calculateFlies(int r, int c, int[] dr, int[] dc) {
        int sum = fly[r][c];

        for (int k = 1; k < M; k++) {
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d] * k;
                int nc = c + dc[d] * k;

                if (validate(nr, nc)) {
                    sum += fly[nr][nc];
                }
            }
        }
        return sum;
    }
    static boolean validate(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}