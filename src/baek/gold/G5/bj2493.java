package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj2493 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        result = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = N; i >= 1; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                int index = stack.pop();
                result[index] = i;
            }

            stack.push(i);
        }

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
