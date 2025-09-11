package baek.silver.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1389 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] map;

    static int INF = Integer.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = INF;


            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = 1;
            map[to][from] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] != INF && map[k][j] != INF) {
                        int connect = Math.min(map[i][j], map[i][k] + map[k][j]);

                        map[i][j] = connect;
                        map[j][i] = connect;
                    }
                }
            }
        }
        int minIdx = 1;
        int Bacon = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    sum += map[i][j];
                }
            }
            if (Bacon > sum) {
                Bacon = sum;
                minIdx = i;
            }
        }
        System.out.println(minIdx);
    }
}
