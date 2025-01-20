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
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    if (chess[i][j]) {
//                        System.out.print("o" + " ");
//                    } else {
//                        System.out.print("x" + " ");
//                    }
//                }
//                System.out.println();
//            }
            count++;
            System.out.println("카운트증가");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (noQueen(start, i)) {
                chess[start][i] = true;
                System.out.println("Placed queen at: " + start + ", " + i);
                if (start + 1 < N) {
                    BTC(start + 1, depth+1);
                }
                chess[start][i] = false;
            }
        }
    }

    static boolean noQueen(int x, int y) {
        for (int i = 0; i < N; i++) {
            if (chess[x][i]) {
                return false;
            }
        }

        for (int i = 0; i < N; i++) {
            if (chess[i][y]) {
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