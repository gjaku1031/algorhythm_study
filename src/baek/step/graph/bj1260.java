package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] visited;
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static Deque<Integer> deq;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        deq = new ArrayDeque<>();
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }


        visited = new boolean[N + 1];
        visited[V] = true;
        deq.addLast(V);

        DFS(V);
        System.out.println();
        visited = new boolean[N + 1];
        visited[V] = true;
        BFS();

    }

    static void BFS() {
        while (!deq.isEmpty()) {
            int now = deq.pollFirst();
            System.out.print(now + " ");

            for (int i = 0; i < graph[now].size(); i++) {
                int temp = graph[now].get(i);
                if (!visited[temp]) {
                    visited[temp] = true;
                    deq.addLast(temp);
                }
            }
        }
    }

    static void DFS(int now) {
        System.out.print(now + " ");
        for (int i = 0; i < graph[now].size(); i++) {
            int next = graph[now].get(i);
            if (!visited[next]) {
                visited[next] = true;
                DFS(next);
            }
        }
    }
}