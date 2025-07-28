package baek.silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj1406 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String line = br.readLine();

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (char c : line.toCharArray()) left.push(c);
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            char order = st.nextToken().charAt(0);

            switch (order) {
                case 'L':
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case 'B':
                    if (!left.isEmpty()) left.pop();
                    break;
                case 'P':
                    char ch = st.nextToken().charAt(0);
                    left.push(ch);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder(left.size() + right.size());
        while (!left.isEmpty()) sb.append(left.pollLast());
        while (!right.isEmpty()) sb.append(right.pop());

        System.out.println(sb);
    }
}