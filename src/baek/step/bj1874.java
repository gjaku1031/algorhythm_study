package baek.step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj1874 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> stack = new Stack<>();
    static int N;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int currentIdx = 0;
        int count = 1;
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        while (true) {
            if (!stack.isEmpty() && stack.peek() == seq[currentIdx]) {
                int a = stack.pop();
                sb.append("-").append("\n");
                currentIdx++;
                if (a == seq[N - 1]) {
                    break;
                }
            } else if (count <= N) {
                stack.push(count);
                sb.append("+").append("\n");
                count++;
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
