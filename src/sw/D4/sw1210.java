package sw.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1210 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int[][] ladder;
    static int result;

    // 우, 좌, 상
    static int[] dx = { 1, -1, 0 };
    static int[] dy = { 0, 0, -1 };

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine());
            result = 0;

            ladder = new int[100][100];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int startX = 0;

            for (int i = 0; i < 100; i++) {
                if (ladder[99][i] == 2) {
                    startX = i;
                    break;
                }
            }
            result = find(startX, 99);

            System.out.println("#" + T + " " + result);
        }
    }

    static int find(int currentX, int currentY) {

        int x = currentX;
        int y = currentY;

        while (y > 0) {

            int nx = x + dx[0];
            int ny = y + dy[0];
            if (valid(nx, ny) && ladder[ny][nx] == 1) { // 좌측
                while (valid(nx, ny) && ladder[ny][nx] == 1) {
                    x = nx;
                    // y는 그대로
                    nx = x + dx[0]; // 계속 왼쪽
                }
            } else {
                nx = x + dx[1];
                ny = y + dy[1];
                if (valid(nx, ny) && ladder[ny][nx] == 1) { // 계속 오른쪽
                    while (valid(nx, ny) && ladder[ny][nx] == 1) {
                        x = nx;
                        nx = x + dx[1];
                    }
                }
            }
            // 3. 위
            // 좌, 우로 이동x => 위로
            y = y + dy[2];

        }
        return x;
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x < 100 && y >= 0 && y < 100;
    }
}
