package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class sw7985 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());
            int length = (int) Math.pow(2, K) - 1;


            Deque<Integer> deque = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < length; i++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            StringBuilder[] sbs = new StringBuilder[K];
            for (int i = 0; i < K; i++) {
                sbs[i] = new StringBuilder();
            }

            for (int i = K - 1; i >= 0; i--) {
                for (int j = 1; j < Math.pow(2, i + 1); j++) {
                    if (j % 2 != 0) {
                        sbs[i].append(deque.pollFirst()).append(" ");
                    } else {
                        deque.addLast(deque.pollFirst());
                    }
                }
            }
            System.out.print("#" + tc + " ");
            for (StringBuilder sb : sbs) {
                System.out.println(sb);
            }
        }
    }

}
