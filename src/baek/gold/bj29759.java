package baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj29759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    static int[][] sudoku;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N * N; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}