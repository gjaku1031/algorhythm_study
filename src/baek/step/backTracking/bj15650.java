package baek.step.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj15650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> deque = new ArrayDeque<>();
    static StringTokenizer st;
    static boolean[] visited;
    static int N, M;



    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        BTC(1, 0);
    }

    static void BTC(int start, int num) {
        if (num == M) {
            if (deque.size() == M) {
                System.out.println(deque.toString().
                        replaceAll(",", "").
                        replaceAll("\\[", "").
                        replaceAll("]", ""));
                return;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (deque.isEmpty() || i > deque.getLast()) {
                    deque.addLast(i);
                }
                BTC(start + 1, num + 1);
                if (deque.getLast() == i) {
                    deque.pollLast();
                }
                visited[i] = false;
            }
        }
    }
}
