package baek.gold.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj4195 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Map<String, Integer> map;
    static int t, F, N;

    static String[][] arr;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {


            F = Integer.parseInt(br.readLine());
            map = new HashMap<>();

            arr = new String[F][2];
            int idx = 0;

            arr = new String[F][2];
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = st.nextToken();
                arr[i][1] = st.nextToken();
                if (!map.containsKey(arr[i][0])) {
                    map.put(arr[i][0], idx++);
                }
                if (!map.containsKey(arr[i][1])) {
                    map.put(arr[i][1], idx++);
                }
            }

            N = map.size();
            DSU dsu = new DSU();
            for (int i = 0; i < F; i++) {
                dsu.union(map.get(arr[i][0]), map.get(arr[i][1]));
                System.out.println(dsu.getSize(dsu.find(map.get(arr[i][0]))));
            }


        }
    }

    static class DSU {
        int[] parent;
        int[] size;

        public DSU() {
            parent = new int[N];
            size = new int[N];

            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb)
                return false;

            if (size[ra] < size[rb]) {
                int temp = ra;
                ra = rb;
                rb = temp;
            }

            parent[rb] = ra;
            size[ra] += size[rb];
            return true;
        }

        int getSize(int idx) {
            return size[idx];
        }
    }

}
/*
 * 
 * 
 * 2 3 Fred Barney Barney Betty Betty Wilma 3 Fred Barney Betty Wilma Barney
 * Betty
 */