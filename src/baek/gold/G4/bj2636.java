package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2636 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R, C;
    static int[][] map;

    static int time = 0; // 녹는데 걸리는 시간
    static int pastCheese; //한시간 전 치즈 갯수

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        // 입력
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 둘레 삭제
        while (hasCheese()){
            bfs();
        }
        System.out.println(time);
        System.out.println(pastCheese);
    }

    static boolean hasCheese() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;

    }

    // 둘레임?
    static void bfs() {
        pastCheese = 0;
        visited = new boolean[R][C];
        time++;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(0);
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int curR = queue.poll();
            int curC = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curR + dir[i][0];
                int nc = curC + dir[i][1];

                if (!valid(nr, nc)) continue;

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if (map[nr][nc] == 0) {
                        queue.add(nr);
                        queue.add(nc);
                    } else {
                        map[nr][nc] = 0;
                        pastCheese++;
                    }
                }
            }
        }
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}
