package sw.D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sw1267 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V, E;
    static List<Integer>[] graph;
    static int[] indegree;


    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            indegree = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                indegree[b]++;
            }

            System.out.print("#" + tc + " ");
            topologicalSort();
            System.out.println();
        }
    }

    static void topologicalSort() {
        Queue<Integer> que = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int node = que.poll();
            result.add(node);

            for (int i = 0; i < graph[node].size(); i++) {
                int now = graph[node].get(i);
                indegree[now]--;
                if (indegree[now] == 0) {
                    que.add(now);
                }
            }
        }

        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }
}
