package baek.step.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] chess;
    static int count = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        chess = new boolean[N][N];
        BTC(0, 0);
        System.out.println(count);

    }

    static void BTC(int start, int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (noQueen(start, i)) {
                chess[start][i] = true;
                BTC(start + 1, depth+1);
                chess[start][i] = false;
            }
        }
    }

    // 해당 좌표에 퀸을 놓을 수 있는지 여부
    static boolean noQueen(int x, int y) {
        for (int i = 0; i < N; i++) { // 가로 세로 검사
            if (chess[x][i]||chess[i][y]) {
                return false;
            }
        }

        for (int i = 1; i < N; i++) { // 1부터 시작해 대각선으로 이동
            if (valid(x - i, y - i) && chess[x - i][y - i]) return false;
            if (valid(x - i, y + i) && chess[x - i][y + i]) return false;
            if (valid(x + i, y - i) && chess[x + i][y - i]) return false;
            if (valid(x + i, y + i) && chess[x + i][y + i]) return false;
        }
        return true;
    }

    // 체스판 안에 들어있는지
    static boolean valid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
//	     n = 3 : 0
//       n = 4 : 2
//       n = 5 : 10
//       n = 6 : 4
//       n = 7 : 40
//       n = 8 : 92
//       n = 9 : 352