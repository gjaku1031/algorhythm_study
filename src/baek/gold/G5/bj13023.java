package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj13023 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;

    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N];
        for (int i = 0; i < N && !found; i++) {
            visited[i] = true;
            bt(i, 1);
            visited[i] = false;
        }
        System.out.println(found ? 1 : 0);
    }

    static void bt(int u, int level) {
        if (found) return;

        if (level == 5) {
            found = true;
            return;
        }
        for (int v : graph[u]) {
            if (!visited[v]) {
                visited[v] = true;
                bt(v, level + 1);
                visited[v] = false;
                if (found) return;
            }
        }
    }
}