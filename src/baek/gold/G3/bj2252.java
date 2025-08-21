package baek.gold.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2252 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static List<Integer>[] graph;
    static int[] indegree;

    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new List[N + 1];
        indegree = new int[N + 1];
                
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }
        topologicalSort();
    }

    static void topologicalSort() {
        Queue<Integer> que = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int node = que.poll();
            order.add(node);

            for (int i = 0; i < graph[node].size(); i++) {
                int now = graph[node].get(i);
                indegree[now]--;
                if (indegree[now] == 0) {
                    que.add(now);
                }
            }
        }

        for (Integer i : order) {
            System.out.print(i + " ");
        }
    }
}