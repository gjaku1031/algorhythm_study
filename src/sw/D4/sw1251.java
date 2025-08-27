package sw.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class sw1251 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            long[] X = new long[N];
            long[] Y = new long[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                X[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                Y[i] = Long.parseLong(st.nextToken());
            }
            double E = Double.parseDouble(br.readLine());

            int M = N * (N - 1) / 2;
            Edge[] edges = new Edge[M];
            int idx = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    long dx = X[i] - X[j];
                    long dy = Y[i] - Y[j];
                    long w2 = dx * dx + dy * dy;
                    edges[idx++] = new Edge(i, j, w2);
                }
            }

            Arrays.sort(edges, 0, idx, (a, b) -> Long.compare(a.w2, b.w2));

            DSU dsu = new DSU(N);
            long sumDist2 = 0L;
            int taken = 0;

            for (int i = 0; i < idx && taken < N - 1; i++) {
                Edge e = edges[i];
                if (dsu.union(e.a, e.b)) {
                    sumDist2 += e.w2;
                    taken++;
                }
            }

            long ans = Math.round(sumDist2 * E);
            System.out.println("#" + tc + " " + ans);
        }
    }

    static class DSU {
        int[] parent, size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        boolean union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra == rb) return false;
            if (size[ra] < size[rb]) {
                int t = ra;
                ra = rb;
                rb = t;
            }
            parent[rb] = ra;
            size[ra] += size[rb];
            return true;
        }
    }

    static class Edge {
        int a, b;
        long w2;
        Edge(int a, int b, long w2) {
            this.a = a;
            this.b = b;
            this.w2 = w2;
        }
    }
}