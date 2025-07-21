package baek.silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] arr;
    static int result_blue = 0;
    static int result_white = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, 0, N);
        System.out.println(result_white);
        System.out.println(result_blue);

    }

    static void recur(int start_r, int start_c, int n) {
        if (allBlue(start_r, start_c, n)) {
            result_blue++;
            return;
        } else if (allWhite(start_r, start_c, n)) {
            result_white++;
            return;
        }

        int half = n / 2;
        recur(start_r, start_c, half);
        recur(start_r, start_c + half, half);
        recur(start_r + half, start_c, half);
        recur(start_r + half, start_c + half, half);
    }

    static boolean allBlue(int r, int c, int n) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (arr[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean allWhite(int r, int c, int n) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (arr[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
