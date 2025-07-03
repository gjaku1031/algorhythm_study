package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj10993 {

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println("*");
            return;
        }

        int height = (1 << N) - 1;
        int width = (1 << (N + 1)) - 3;

        map = new char[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(map[i], ' ');
        }

        // 초기 방향과 시작점 설정
        boolean isInitialUpward = (N % 2 == 1);
        int startRow = isInitialUpward ? 0 : height - 1;
        int startCol = width / 2;

        draw(N, startRow, startCol, isInitialUpward);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            int lastStarIndex = -1;
            for (int j = 0; j < width; j++) {
                if (map[i][j] == '*') {
                    lastStarIndex = j;
                }
            }
            if (lastStarIndex != -1) {
                sb.append(new String(map[i], 0, lastStarIndex + 1));
            }
            if (i < height - 1) {
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    /**
     * 재귀적으로 별을 그리는 함수
     * @param n 현재 레벨
     * @param r 현재 레벨 삼각형의 꼭짓점 행(row) 좌표
     * @param c 현재 레벨 삼각형의 꼭짓점 열(col) 좌표
     * @param isUpward 현재 삼각형이 위로 향하는지 여부
     */
    static void draw(int n, int r, int c, boolean isUpward) {
        if (n == 0) {
            return;
        }

        int h_border = 1 << (n - 1);

        if (isUpward) { // 위로 향하는 삼각형
            // 빗변 그리기
            for (int i = 0; i < h_border; i++) {
                map[r + i][c - i] = '*';
                map[r + i][c + i] = '*';
            }
            // 밑변 그리기
            Arrays.fill(map[r + h_border - 1], c - (h_border - 1), c + h_border, '*');

            // 다음 재귀 호출 (아래로 향하는 패턴)
            int next_r = r + h_border / 2;
            draw(n - 1, next_r, c, !isUpward);

        } else { // 아래로 향하는 삼각형
            // 빗변 그리기
            for (int i = 0; i < h_border; i++) {
                map[r - i][c - i] = '*';
                map[r - i][c + i] = '*';
            }
            // 윗변 그리기
            Arrays.fill(map[r - h_border + 1], c - (h_border - 1), c + h_border, '*');

            // 다음 재귀 호출 (위로 향하는 패턴)
            int next_r = r - h_border / 2;
            draw(n - 1, next_r, c, !isUpward);
        }
    }
}