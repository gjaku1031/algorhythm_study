package baek.silver.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10157 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int C, R, K;
    static int r, c;

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        if (K > C * R) {
            System.out.println(0);
            return;
        }

        boolean[][] visited = new boolean[C + 1][R + 1];

        c = 1;
        r = 1;
        visited[c][r] = true;
        int count = 1;
        int d = 0;

        while (count < K) {
            int nc = c + dir[d][0];
            int nr = r + dir[d][1];

            if (nc > 0 && nc <= C && nr > 0 && nr <= R && !visited[nc][nr]) {
                c = nc;
                r = nr;
                visited[c][r] = true;
                count++;
            } else {
                d = (d + 1) % 4;
            }
        }

        System.out.println(c + " " + r);
    }
}