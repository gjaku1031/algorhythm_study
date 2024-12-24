package baek.step.arr2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[100][100];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            attach(board, x, y);
        }

        countBoard(board);
    }

    static void attach(int[][] board, int x, int y) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[x + i][y + j] = 1;
            }
        }
    }

    static void countBoard(int[][] board) {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                sum += board[i][j];
            }
        }
        System.out.println(sum);
    }
}
