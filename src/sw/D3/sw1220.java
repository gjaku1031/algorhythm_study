package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1220 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int result;

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());
            result = 0;
            int[][] magnet = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            deadlock(magnet, N);
            System.out.println("#" + tc + " " + result);
        }
    }

    static void deadlock(int[][] magnet, int N) {
        for (int j = 0; j < N; j++) {
            int last = 0;
            for (int i = 0; i < N; i++) {
                if (magnet[i][j] == 1) {
                    last = 1;
                } else if (magnet[i][j] == 2) {
                    if (last == 1) {
                        result++;
                        last = 0;
                    }
                }
            }
        }
    }
}