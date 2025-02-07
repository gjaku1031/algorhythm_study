package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1149 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] cost;
    static int N;
    static int[][] home;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        home = new int[N][3];

        //입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            // cost[집순서][0:R, 1:G, 2:B]
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < 9; i++) {

        }

        // home[집순서][0:R, 1:G, 2:B]
        home[0][0] = cost[0][0];
        home[0][1] = cost[0][1];
        home[0][2] = cost[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int min = 0;
                if (j == 0) {
                    min = Math.min(home[i - 1][1], home[i - 1][2]);
                } else if (j == 1) {
                    min = Math.min(home[i - 1][0], home[i - 1][2]);
                } else if (j == 2) {
                    min = Math.min(home[i - 1][0], home[i - 1][1]);
                }
                home[i][j] = cost[i][j] + min;
            }
        }
        Arrays.sort(home[N - 1]);
        System.out.println(home[N - 1][0]);
    }
}