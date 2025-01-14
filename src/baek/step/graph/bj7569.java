package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> deq = new ArrayDeque<>();
    static StringTokenizer st;
    static int[] dx = {1,0,0,-1,0,0};
    static int[] dy = {0,0,1,0,-1,0};
    static int[] dz = {0,1,0,0,0,-1};
    static int[][][] field;
    static int M, N, H;
    static int result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        field = new int[N][M][H];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    field[i][j][k] = num;
                    if (num == 1) {
                        deq.addLast(new Node(i, j, k, 1));
                    }
                }
            }
        }
        BFS();
        search();

    }

    static void BFS() {
        while (!deq.isEmpty()) {
            Node now = deq.pollFirst();
            for (int i = 0; i < 6; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];
                int nz = now.getZ() + dz[i];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) {
                    continue;
                }
                if (field[nx][ny][nz] != 0) {
                    continue;
                }
                field[nx][ny][nz] = 1;
                deq.addLast(new Node(nx, ny, nz, now.getLevel() + 1));
                result = now.getLevel();
            }
        }

    }

    static void search() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if (field[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(result);

    }

    static class Node {
        int x;
        int y;
        int z;
        int level;

        public Node(int x, int y, int z, int level) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.level = level;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ(){
            return z;}

        public int getLevel() {
            return level;
        }
    }
}
