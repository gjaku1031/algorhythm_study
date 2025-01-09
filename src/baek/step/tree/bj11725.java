package baek.step.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11725 {
    static int x, y, N;
    static StringTokenizer st;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        visited[1] = true;
        DFS(1, 0);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }


    static void DFS(int now, int past) {
        parent[now] = past;
        for (int i = 0; i < graph[now].size(); i++) {
            int a = graph[now].get(i);
            if (!visited[a]) {
                visited[a] = true;
                DFS(a, now);
            }
        }
    }
}