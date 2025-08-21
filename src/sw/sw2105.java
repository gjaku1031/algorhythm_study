package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2105 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static int[][] dir = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    static int N;
    static int[][] map;
    static int max;

    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max = -1;
            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
                    boolean[] visited = new boolean[101];
                    visited[map[i][j]] = true;
                    search(i, j, i, j, 0, visited);
                    visited[map[i][j]] = false;
                }
            }
            result.append("#" + tc + " " + max).append("\n");
        }
        System.out.println(result);
    }

    static void search(int r, int c, int sr, int sc, int d0Cnt, boolean[] visited) {
        if (d0Cnt > 0) {
            int tr = r + dir[1][0];
            int tc = c + dir[1][1];
            if (valid(tr, tc)) {
                int val = map[tr][tc];
                if (!visited[val]) {
                    visited[val] = true;
                    turn(tr, tc, sr, sc, d0Cnt, 1, visited);
                    visited[val] = false;
                }
            }
        }

        int nr = r + dir[0][0];
        int nc = c + dir[0][1];
        if (valid(nr, nc)) {
            int val = map[nr][nc];
            if (!visited[val]) {
                visited[val] = true;
                search(nr, nc, sr, sc, d0Cnt + 1, visited);
                visited[val] = false;
            }
        }
    }

    static void turn(int r, int c, int sr, int sc, int d0Cnt, int d1Cnt, boolean[] visited) {
        int half = d0Cnt + d1Cnt;
        if (2 * half > max && back(r, c, sr, sc, d0Cnt, d1Cnt, visited)) {
            max = 2 * half;
        }

        int nr = r + dir[1][0];
        int nc = c + dir[1][1];

        if (valid(nr, nc)) {
            int val = map[nr][nc];
            if (!visited[val]) {
                visited[val] = true;
                turn(nr, nc, sr, sc, d0Cnt, d1Cnt + 1, visited);
                visited[val] = false;
            }
        }
    }

    static boolean back(int r, int c, int sr, int sc, int d0Cnt, int d1Cnt, boolean[] visited) {
        int nr = r, nc = c;

        boolean[] backSeen = new boolean[101];

        for (int i = 0; i < d0Cnt; i++) {
            nr += dir[2][0];
            nc += dir[2][1];
            if (!valid(nr, nc)) return false;
            if (nr == sr && nc == sc) return false;
            int val = map[nr][nc];
            if (visited[val] || backSeen[val]) return false;
            backSeen[val] = true;
        }

        for (int i = 0; i < d1Cnt - 1; i++) {
            nr += dir[3][0];
            nc += dir[3][1];
            if (!valid(nr, nc)) return false;
            if (nr == sr && nc == sc) return false;
            int val = map[nr][nc];
            if (visited[val] || backSeen[val]) return false;
            backSeen[val] = true;
        }

        int fr = nr + dir[3][0];
        int fc = nc + dir[3][1];
        return fr == sr && fc == sc;
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}