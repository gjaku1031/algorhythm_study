package sw.D3;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1216 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static char[][] board;
    static int result;
    static StringBuilder sb1;
    static StringBuilder sb2;

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            result = 0;
            board = new char[100][100];
            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                for (int j = 0; j < 100; j++) {
                    board[i][j] = str.charAt(j);
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    sb1 = new StringBuilder();
                    sb2 = new StringBuilder();
                    for (int k = j; k < 100; k++) {
                        sb1.append(board[i][k]);
                        if (isPal(sb1.toString())) {
                            result = max(result, sb1.length());
                        }

                        sb2.append(board[k][i]);
                        if (isPal(sb2.toString())) {
                            result = max(result, sb2.length());
                        }
                    }

                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }

    static boolean isPal(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
