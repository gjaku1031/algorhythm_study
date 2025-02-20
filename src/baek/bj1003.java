package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1003 {
    static int count_zero;
    static int count_one;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int a = Integer.parseInt(br.readLine());
            count_zero = 0;
            count_one = 0;
            fibonacci(a);
            sb.append(count_zero).append(" ").append(count_one).append("\n");
        }
        System.out.println(sb);

    }

    static int fibonacci(int n) {
        if (n == 0) {
            count_zero++;
            return 0;
        } else if (n == 1) {
            count_one++;
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }
}
