package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2448 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N * 2 - 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');

        }

        func(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2 - 1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void func(int top_r, int top_c, int height) {
        if (height == 3) {
            arr[top_r][top_c] = '*';
            arr[top_r + 1][top_c - 1] = '*';
            arr[top_r + 1][top_c + 1] = '*';
            for (int i = 0; i < 5; i++) {
                arr[top_r + 2][top_c - 2 + i] = '*';
            }
            return;
        }
        int nextHeight = height / 2;
        func(top_r, top_c, nextHeight);
        func(top_r + nextHeight, top_c - nextHeight, nextHeight);
        func(top_r + nextHeight, top_c + nextHeight, nextHeight);
    }
}
