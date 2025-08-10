package baek.silver.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1325 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static List<Integer>[] graph;

    static int[] countArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        countArr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            countArr[i] = BFS(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (countArr[i] > max) max = countArr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (countArr[i] == max) {
                if (sb.length() > 0) sb.append(' ');
                sb.append(i);
            }
        }
        System.out.println(sb);
    }


    static int BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        visited = new boolean[N + 1];
        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}