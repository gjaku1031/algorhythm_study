package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1976 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        DSU dsu = new DSU();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (i != j && connected != 0) dsu.union(i, j);
            }
        }

        int firstRoot = -1;
        boolean ok = true;
        int read = 0;
        while (read < M) {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
                continue;
            }
            int city = Integer.parseInt(st.nextToken());
            int r = dsu.find(city);
            if (firstRoot == -1) firstRoot = r;
            else if (firstRoot != r) { ok = false; break; }
            read++;
        }

        System.out.println(ok ? "YES" : "NO");
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
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false;

            if (size[ra] < size[rb]) {
                int t = ra; ra = rb; rb = t;
            }

            parent[rb] = ra;
            size[ra] += size[rb];
            return true;
        }
    }
}
