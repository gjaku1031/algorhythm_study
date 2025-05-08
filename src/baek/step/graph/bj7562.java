package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj7562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static StringTokenizer st;
    static int next_x, next_y;
    static int now_x, now_y;
    static int N;
    static int I;
    static Deque<Node> deq = new ArrayDeque<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            I = Integer.parseInt(br.readLine());
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            now_x = Integer.parseInt(st.nextToken());
            now_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            next_x = Integer.parseInt(st.nextToken());
            next_y = Integer.parseInt(st.nextToken());

            Node node = new Node(now_x, now_y, 0);
            visited[now_x][now_y] = true;
            deq.addLast(node);
            BFS();
        }
    }

    static class Node {
        int locX;
        int locY;
        int level;

        public Node(int locX, int locY, int level) {
            this.locX = locX;
            this.locY = locY;
            this.level = level;
        }

        public int getLocX() {
            return locX;
        }

        public int getLocY() {
            return locY;
        }

        public int getLevel() {
            return level;
        }
    }

    static void BFS() {
        while (!deq.isEmpty()) {
            Node now = deq.pollFirst();
            if (now.getLocX() == next_x && now.getLocY() == next_y) {
                System.out.println(now.getLevel());
            }
            for (int i = 0; i < 8; i++) {
                int nx = now.getLocX() + dx[i];
                int ny = now.getLocY() + dy[i];
                if (nx < 0 || ny < 0 || nx >= I || ny >= I) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                deq.addLast(new Node(nx, ny, now.getLevel() + 1));
            }
        }

    }
}
