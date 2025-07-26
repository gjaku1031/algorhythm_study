package codeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2025 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, Q;
    static char[][] stones;
    static int[][] journey;

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        stones = new char[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                stones[i][j] = line.charAt(j);
            }
        }

        Q = Integer.parseInt(br.readLine());
        journey = new int[Q + 1][Q + 1];
        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= Q; j++) {
                journey[i][j] = Integer.parseInt(st.nextToken());
            }
        }




    }


}
