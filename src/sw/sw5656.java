package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class sw5656 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, W, H;
    static int[][] map;

    static int result;

    static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Node {
        int r, c, power;

        Node(int r, int c, int power) {
            this.r = r;
            this.c = c;
            this.power = power;
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            for (int r = 0; r < H; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < W; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            result = Integer.MAX_VALUE;

            dfs(0, copy(map));
            System.out.println("#" + tc + " " + result);
        }
    }
    static void dfs(int level, int[][] board) {
        int remain = count(board);
        if (remain == 0) {
            result = 0;
            return;
        }
        if (level == N) {
            result = Math.min(result, remain);
            return;
        }
        if (result == 0) return;


        for (int col = 0; col < W; col++) {
            int[][] next = copy(board);
            explode(next, col);
            applyGravity(next);
            dfs(level + 1, next);
            if (result == 0) return;
        }
    }

    static void explode(int[][] b, int col) {
        int r = findTop(b, col);
        if (r == -1) return;

        int power = b[r][col];
        if (power <= 1) {
            b[r][col] = 0;
            return;
        }

        ArrayDeque<Node> q = new ArrayDeque<>();
        b[r][col] = 0;
        q.offer(new Node(r, col, power));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int dr = DIR[d][0], dc = DIR[d][1];

                // 현재 벽돌의 power-1 만큼 직선으로 확장
                for (int dist = 1; dist < cur.power; dist++) {
                    int nr = cur.r + dr * dist;
                    int nc = cur.c + dc * dist;
                    if (!valid(nr, nc)) break; // 범위 밖이면 그 방향 끝

                    if (b[nr][nc] == 0) continue; // 빈 칸은 통과

                    int val = b[nr][nc];
                    if (val > 1) {
                        // 값이 2 이상이면 큐에 넣고, 즉시 0으로 만들어 중복 처리 방지
                        q.offer(new Node(nr, nc, val));
                    }
                    b[nr][nc] = 0; // 1이든 그 이상이든 일단 파괴
                }
            }
        }
    }

    static int findTop(int[][] b, int col) {
        for (int r = 0; r < H; r++) {
            if (b[r][col] != 0) return r;
        }
        return -1;
    }

    static void applyGravity(int[][] b) {
        for (int c = 0; c < W; c++) {
            int write = H - 1;
            for (int r = H - 1; r >= 0; r--) {
                if (b[r][c] != 0) {
                    int val = b[r][c];
                    b[r][c] = 0;
                    b[write--][c] = val;
                }
            }
        }
    }

    static int count(int[][] b) {
        int cnt = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (b[r][c] != 0) cnt++;
            }
        }
        return cnt;
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < H && 0 <= c && c < W;
    }

    static int[][] copy(int[][] src) {
        int[][] dst = new int[H][W];
        for (int r = 0; r < H; r++) {
            System.arraycopy(src[r], 0, dst[r], 0, W);
        }
        return dst;
    }
}
