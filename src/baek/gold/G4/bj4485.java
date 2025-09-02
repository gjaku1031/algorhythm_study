package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj4485 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] thief;
    static int INF = Integer.MAX_VALUE;

    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {

        int tc = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                return;
            }
            thief = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    thief[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("Problem " + tc++ +": "+ dijkstra());
        }
    }

    static int dijkstra() {
        int[][] dist = new int[N][N];
        for (int[] row : dist) {
            Arrays.fill(row, INF);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[0]));
        dist[0][0] = thief[0][0];
        pq.add(new int[] { thief[0][0], 0, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], r = cur[1], c = cur[2];

            if (cost > dist[r][c]) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dir[d][0], nc = c + dir[d][1];
                if (!valid(nr, nc)) {
                    continue;
                }

                int nextCost = cost + thief[nr][nc];
                if (dist[nr][nc] > nextCost) {
                    dist[nr][nc] = nextCost;
                    pq.add(new int[] { nextCost, nr, nc });
                }
            }
        }
        return dist[N - 1][N - 1];
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}