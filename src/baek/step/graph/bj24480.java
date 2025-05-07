package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj24480 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] visited;
    static int[] nodeIdx;
    static int N, M, R;
    static int count = 1;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

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
            graph[i].sort(Collections.reverseOrder());
        }


        nodeIdx = new int[N + 1];
        visited = new boolean[N + 1];
        visited[R] = true;
        DFS(R);
        for (int i = 1; i <= N; i++) {
            System.out.println(nodeIdx[i]);
        }

    }

    static void DFS(int now) {
        nodeIdx[now] = count;
        count++;

        for (int i = 0; i < graph[now].size(); i++) {
            int next = graph[now].get(i);
            if (!visited[next]) {
                visited[next] = true;
                DFS(next);
            }
        }
    }
}