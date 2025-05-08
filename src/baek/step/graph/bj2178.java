package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] visited;

    static int[][] maze;

    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new int[N][M];

    
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {

                maze[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        Queue<int[]> que = new ArrayDeque<>();

        que.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (!que.isEmpty()) {
            int[] now = que.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (maze[nx][ny] == 0) {
                    continue;
                }

                if (visited[nx][ny] != 0) {
                    continue;
                }

                visited[nx][ny] = visited[now[0]][now[1]] + 1;

                que.add(new int[]{nx, ny});
            }
        }

        return visited[N - 1][M - 1];
    }
}