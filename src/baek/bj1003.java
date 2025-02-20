package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1003 {
    static int count_zero;
    static int count_one;
    static StringBuilder sb = new StringBuilder();
    static int[] fibo = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i < 41; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        while (T-- > 0) {
            int a = Integer.parseInt(br.readLine());
            count_zero = 0;
            count_one = 0;
            fibonacci(a);
            sb.append(count_zero).append(" ").append(count_one).append("\n");
        }
        System.out.println(sb);

    }

    static void fibonacci(int n) {
        if (n == 0) {
            count_zero++;
        } else if (n == 1) {
            count_one++;
        } else {
            return;
        }

    }
}
