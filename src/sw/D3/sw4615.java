package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw4615 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, M;
    static int[][] board;

    static int c, r, color;

    // 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하
    static int[] dc = { 1, -1, 0, 0, 1, 1, -1, -1 };
    static int[] dr = { 0, 0, -1, 1, -1, 1, -1, 1 };

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            init();

        }
    }

    static void init() {
        board = new int[N][N];

        board[N / 2][N / 2] = 2;
        board[N / 2 - 1][N / 2] = 1;
        board[N / 2][N / 2 - 1] = 1;
        board[N / 2 - 1][N / 2 - 1] = 2;
    }

    static void othello() throws IOException {
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            c = Integer.parseInt(st.nextToken()) - 1;
            r = Integer.parseInt(st.nextToken()) - 1;
            color = Integer.parseInt(st.nextToken());
            board[c][r] = color;

            for (int j = 0; j < 8; j++) {
                int nc = c + dc[j];
                int nr = r + dr[j];

            }
        }
    }

    static void reverse(int nc, int nr) {
        if (valid(nc, nr) && board[nc][nr] + board[c][r] == 3) {
            int current_c = nc;
            int current_r = nr;
            while (true) {
                if (valid(current_c, current_r)) {
                    return;
                }
            }
        }

    }

    static boolean valid(int nc, int nr) {
        return nc >= 0 || nc < N || nr >= 0 || nr < N;
    }
}