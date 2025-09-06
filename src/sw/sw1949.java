package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1949 {

    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int maxLength;
    static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
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
                // 1. 다음 위치가 현재 위치보다 낮은 경우
                if (map[nr][nc] < map[r][c]) {
                    dfs(nr, nc, length + 1, hasCut);
                }
                // 2. 다음 위치가 현재 위치보다 높거나 같지만, 아직 깎지 않았고 깎아서 낮게 만들 수 있는 경우
                else if (!hasCut && map[nr][nc] - K < map[r][c]) {
                    int originalHeight = map[nr][nc]; // 원래 높이 저장
                    map[nr][nc] = map[r][c] - 1; // 현재보다 1 낮은 높이로 깎음
                    dfs(nr, nc, length + 1, true);
                    map[nr][nc] = originalHeight; // 높이 복원 (백트래킹)
                }
            }
        }

        visited[r][c] = false; // 다른 경로에서 방문할 수 있도록 방문 여부 해제
    }
}
