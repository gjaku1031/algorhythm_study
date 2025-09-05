package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] map;

    static boolean[][][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }
        visited = new boolean[N][M][2];
        System.out.println(bfs());

    }

    static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {

                int[] now = queue.poll();
                int r = now[0], c = now[1], isBroken = now[2];

                if(r==N-1 && c ==M-1) return count;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dir[d][0];
                    int nc = c + dir[d][1];

                    if (!valid(nr, nc)) continue;

                    if (map[nr][nc] == 0) {
                        if (!visited[nr][nc][isBroken]) {
                            visited[nr][nc][isBroken] = true;
                            queue.add(new int[]{nr, nc, isBroken});
                        }
                    } else {
                        if (isBroken == 0 && !visited[nr][nc][1]) {
                            visited[nr][nc][1] = true;
                            queue.add(new int[]{nr, nc, 1});
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
