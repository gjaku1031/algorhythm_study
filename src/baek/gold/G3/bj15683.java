package baek.gold.G3;

import javax.imageio.ImageReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj15683 {

    static class CCTV {
        int r, c, type;

        public CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] map;
    static int[][] cover;
    static int uncovered;
    static int best = Integer.MAX_VALUE;
    static List<CCTV> cams = new ArrayList<>();

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static final int[][][] dirs = {
            null,
            {{0}, {1}, {2}, {3}},
            {{0, 1}, {2, 3}},
            {{0, 3}, {3, 1}, {1, 2}, {2, 0}},
            {{0, 2, 3}, {0, 1, 3}, {0, 1, 2}, {1, 2, 3}},
            {{0, 1, 2, 3}}
    };

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cover = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
                if (v == 0) uncovered++;
                else if (1 <= v && v <= 5) {
                    cams.add(new CCTV(i, j, v));
                }
            }
        }
        dfs(0);
        System.out.println(best);
    }

    static void dfs(int idx) {
        if (idx == cams.size()) {
            best = Math.min(best, uncovered);
            return;
        }

        CCTV cam = cams.get(idx);
        int type = cam.type;

        for (int[] dirs : dirs[type]) {
            for (int d : dirs) mark(cam.r, cam.c, d);
            dfs(idx + 1);
            for (int d : dirs) unmark(cam.r, cam.c, d);
        }
    }

    static void mark(int r, int c, int d) {
        int nr = r + dir[d][0];
        int nc = c + dir[d][1];

        while (valid(nr, nc) && map[nr][nc] != 6) {
            if (map[nr][nc] == 0) {
                if (cover[nr][nc] == 0) uncovered--;
                cover[nr][nc]++;
            }
            nr += dir[d][0];
            nc += dir[d][1];
        }
    }

    static void unmark(int r, int c, int d) {
        int nr = r + dir[d][0];
        int nc = c + dir[d][1];

        while (valid(nr, nc) && map[nr][nc] != 6) {
            if (map[nr][nc] == 0) {
                cover[nr][nc]--;
                if (cover[nr][nc] == 0) uncovered++;
            }
            nr += dir[d][0];
            nc += dir[d][1];
        }
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}