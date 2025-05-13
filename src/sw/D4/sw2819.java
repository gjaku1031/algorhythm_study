package sw.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class sw2819 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int[][] board;
    static int[] dc = { 1, -1, 0, 0 };
    static int[] dr = { 0, 0, -1, 1 };
    static HashSet<String> set;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            board = new int[4][4];
            set = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int level = 1;
                    sb.append(board[i][j]);

                    BTC(i, j, level);

                    sb.deleteCharAt(0);
                }
            }

            System.out.println("#" + tc + " " + set.size());
        }
    }

    static void BTC(int c, int r, int level) {
        if (level == 7) {
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nc = c + dc[i];
            int nr = r + dr[i];

            if (valid(nc, nr)) {
                sb.append(board[nc][nr]);

                BTC(nc, nr, level + 1);
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }

    static boolean valid(int nc, int nr) {
        return 0 <= nc && nc < 4 && 0 <= nr && nr < 4;
    }
}
 