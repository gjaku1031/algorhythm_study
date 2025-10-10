package baek.bronze.B1;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class bj2748 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        if (n == 0) {
            System.out.println(0);
            return;
        }
        long a = 0L;
        long b = 1L;
        for (int i = 2; i <= n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        System.out.println(b);
    }
}
