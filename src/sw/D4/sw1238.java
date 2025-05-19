package sw.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class sw1238 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static Deque<Integer> deque;
    static int[] level;
    static int max_level;

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            graph = new ArrayList[101];
            level = new int[101];
            for (int i = 0; i < 101; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
            }

            deque = new ArrayDeque<>();
            visited = new boolean[101];
            deque.add(start);
            visited[start] = true;
            level[start] = 1;
            max_level = 1;
            BFS();

            for (int i = 0; i < 101; i++) {
                if (level[100 - i] == max_level) {
                    System.out.println("#" + tc + " " + (100 - i));
                    break;
                }
            }
        }
    }

    static void BFS() {
        while (!deque.isEmpty()) {
            int now = deque.pollFirst();

            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if (!visited[next]) {
                    level[next] = level[now] + 1;
                    max_level = Math.max(level[next], max_level);
                    visited[next] = true;
                    deque.addLast(graph[now].get(i));
                }
            }
        }

    }
}