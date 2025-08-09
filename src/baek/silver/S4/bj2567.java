package baek.silver.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2567 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        map = new int[101][101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int x = r; x < r + 10; x++) {
                for (int y = c; y < c + 10; y++) {
                    map[x][y] = 1;
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int perimeter = 0;

        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100; y++) {
                if (map[x][y] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || nx > 100 || ny < 0 || ny > 100 || map[nx][ny] == 0) {
                            perimeter++;
                        }
                    }
                }
            }
        }

        System.out.println(perimeter);
    }
}
