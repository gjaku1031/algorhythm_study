package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1949 {

    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int maxLength;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];
            maxLength = 0;
            int maxHeight = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > maxHeight) {
                        maxHeight = map[i][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxHeight) {
                        dfs(i, j, 1, false);
                    }
                }
            }
            System.out.println("#" + test_case + " " + maxLength);
        }
    }

    static void dfs(int r, int c, int length, boolean hasCut) {
        maxLength = Math.max(maxLength, length);
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                if (map[nr][nc] < map[r][c]) {
                    dfs(nr, nc, length + 1, hasCut);
                }
                else if (!hasCut && map[nr][nc] - K < map[r][c]) {
                    int originalHeight = map[nr][nc];
                    map[nr][nc] = map[r][c] - 1;
                    dfs(nr, nc, length + 1, true);
                    map[nr][nc] = originalHeight;
                }
            }
        }

        visited[r][c] = false;
    }
}
