package baek.gold.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int K;
    static int W, H;
    static int[][] map;

    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int[][] horseMoving = { { -2, -1 }, { -2, 1 }, { 2, -1 }, { 2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 },
            { 1, 2 } };

    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0, 0, 0 });

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], k = cur[2], d = cur[3];
            if (r == H - 1 && c == W - 1) {
                System.out.println(d);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if (valid(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc][k]) {
                    visited[nr][nc][k] = true;
                    queue.add(new int[] { nr, nc, k, d + 1 });
                }
            }
            if (k < K) {
                for (int i = 0; i < 8; i++) {
                    int nr = r + horseMoving[i][0], nc = c + horseMoving[i][1];
                    if (valid(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc][k + 1]) {
                        visited[nr][nc][k + 1] = true;
                        queue.add(new int[] { nr, nc, k + 1, d + 1 });
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < H && 0 <= c && c < W;
    }
}