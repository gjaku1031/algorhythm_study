package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> deq = new ArrayDeque<>();
    static StringTokenizer st;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] field;
    static int result;
    static int M, N;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                field[i][j] = num;
                if (num == 1) {
                    deq.addLast(new Node(i, j, 1));
                }
            }
        }
        BFS();
        search();
    }

    static void BFS() {
        while (!deq.isEmpty()) {
            Node now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (field[nx][ny] != 0) {
                    continue;
                }
                field[nx][ny] = 1;
                deq.addLast(new Node(nx, ny, now.getLevel() + 1));
                result = now.getLevel();
            }
        }

    }

    static void search() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(result);

    }

    static class Node {
        int x;
        int y;
        int level;

        public Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getLevel() {
            return level;
        }
    }
}
