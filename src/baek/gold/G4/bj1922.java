package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1922 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, w);
        }
        Arrays.sort(edges);
        DSU dsu = new DSU();

        long total = 0;
        int picked = 0;
        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                total += e.w;
                if (++picked == N - 1) {
                    break;
                }
            }
        }
        System.out.println(total);
    }

    static class DSU {

        int[] parent, size;

        public DSU() {
            parent = new int[N + 1];
            size = new int[N + 1];
            for (int i = 1; i <= N; i++) {
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
                int temp = ra;
                ra = rb;
                rb = temp;
            }
            parent[rb] = ra;
            size[ra] += size[rb];
            return true;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
}
