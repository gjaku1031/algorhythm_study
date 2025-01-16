package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj16928 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> deque = new ArrayDeque<>();
    static HashMap<Integer, Integer> tunnel;
    static StringTokenizer st;
    static int N, M;
    static int[] visited = new int[101];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tunnel = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tunnel.put(start, end);
        }
        visited[1] = 0;
        deque.addLast(1);
        BFS();
    }

    static void BFS() {
        while (!deque.isEmpty()) {
            int now = deque.pollFirst();
            if (now == 100) {
                System.out.println(visited[now]);
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next > 100) {
                    continue;
                }
                if (tunnel.containsKey(next)) {
                    next = tunnel.get(next);
                }
                if (visited[next] != 0) {
                    continue;
                }
                visited[next] = visited[now] + 1;
                deque.addLast(next);
            }
        }
    }
}
