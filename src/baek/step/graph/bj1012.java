package baek.step.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] visited;
    static int T, M, N, K;
    static int[][] cabs;
    static int count;


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            count = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cabs = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                cabs[a][b] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (cabs[j][k] == 1 && !visited[j][k]) {
                        count++;
                        visited[j][k] = true;
                        search(j, k);
                    }
                }
            }
            System.out.println(count);
        }


    }
    public static void search(int x, int y) {
        // 위
        if (y > 0 && !visited[x][y - 1] && cabs[x][y - 1] == 1) {
            visited[x][y - 1] = true;
            search(x, y - 1);
        }

        // 아래
        if (y < N - 1 && !visited[x][y + 1] && cabs[x][y + 1] == 1) {
            visited[x][y + 1] = true;
            search(x, y + 1);
        }

        // 왼쪽
        if (x > 0 && !visited[x - 1][y] && cabs[x - 1][y] == 1) {
            visited[x - 1][y] = true;
            search(x - 1, y);
        }

        //오른쪽
        if (x < M - 1 && !visited[x + 1][y] && cabs[x + 1][y] == 1) {
            visited[x + 1][y] = true;
            search(x + 1, y);
        }
    }
}
