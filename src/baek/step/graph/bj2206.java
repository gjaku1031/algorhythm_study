package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj2206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Unit> deq = new ArrayDeque<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringTokenizer st;
    static int[][] visited;
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }
        visited[0][0] = 1;
        deq.addLast(new Unit(0, 0, true));
        BFS();
    }

    public static class Unit {
        int x;
        int y;
        boolean wall = false;

        public Unit(int x, int y, boolean wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean canDes() {
            return wall;
        }
    }

    static void BFS() {
        while (!deq.isEmpty()) {
            Unit now = deq.pollFirst();
            if (now.getX() == N - 1 && now.getY() == M - 1) {
                System.out.println(visited[N - 1][M - 1]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now.getX() + dx[i];
                int nextY = now.getY() + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if (visited[now.getX()][now.getY()] <= visited[nextX][nextY]) {
                    continue;
                }

                if (now.canDes() == false && map[nextX][nextY] == 1) { //부실 수 없을 때
                    continue;
                }
                if (now.canDes() == true && map[nextX][nextY] == 1) {
                    visited[nextX][nextY] = visited[now.getX()][now.getY()] + 1;
                    deq.addLast(new Unit(nextX, nextY, false));
                }
                if (map[nextX][nextY] == 0) {
                    visited[nextX][nextY] = visited[now.getX()][now.getY()] + 1;
                    deq.addLast(new Unit(nextX, nextY, now.canDes()));
                }
            }
        }
        System.out.println(-1);
    }
}
