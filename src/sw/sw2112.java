package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sw2112 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static int D, W, K;
    static int[][] film;

    static int result;
    static List<List<Integer>> res;
    static boolean success = false;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D + 1][W + 1];

            for (int i = 1; i <= D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = 0;
            int len = 1;
            System.out.println("#" + tc + " " + result);
        }
    }

    static void dfs(int start) {

    }
}