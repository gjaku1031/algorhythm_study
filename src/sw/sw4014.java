package sw;

import java.io.*;
import java.util.*;

public class sw4014 {

    static int N, X;
    static int[][] map;

    static boolean canBuild(int[] line) {
        boolean[] used = new boolean[N];
        for (int c = 0; c < N - 1; c++) {
            int a = line[c];
            int b = line[c + 1];

            if (a == b) continue;
            if (Math.abs(a - b) > 1) return false;

            if (b - a == 1) {
                for (int k = 0; k < X; k++) {
                    int idx = c - k;
                    if (idx < 0) return false;
                    if (line[idx] != a) return false;
                    if (used[idx]) return false;
                }
                for (int k = 0; k < X; k++) used[c - k] = true;

            } else if (b - a == -1) {
                for (int k = 1; k <= X; k++) {
                    int idx = c + k;
                    if (idx >= N) return false;
                    if (line[idx] != b) return false;
                    if (used[idx]) return false;
                }
                for (int k = 1; k <= X; k++) used[c + k] = true;
                c += X - 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 0;
            int[] line = new int[N];

            for (int r = 0; r < N; r++) {
                if (canBuild(map[r])) ans++;
            }
            for (int c = 0; c < N; c++) {
                for (int r = 0; r < N; r++) line[r] = map[r][c];
                if (canBuild(line)) ans++;
            }

            out.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.print(out.toString());
    }
}