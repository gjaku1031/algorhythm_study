package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj9184 {
    static StringTokenizer st;
    static int[][][] w = new int[21][21][21];


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        w[20][20][20] = 1048576;
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        w[i][j][k] = 1;
                    }
                }
            }
        }
        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                for (int k = 1; k < 21; k++) {
                    if (i < j && j < k) {
                        w[i][j][k] = w[i][j][k - 1] + w[i][j - 1][k - 1] - w[i][j - 1][k];
                    } else {
                        w[i][j][k] = w[i - 1][j][k] + w[i - 1][j - 1][k] + w[i - 1][j][k - 1] - w[i - 1][j - 1][k - 1];
                    }
                }
            }
        }

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            if (a <= 0 || b <= 0 || c <= 0) {
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + 1);
            } else if (a > 20 || b > 20 || c > 20) {
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + 1048576);

            } else {
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w[a][b][c]);
            }
        }
    }
}