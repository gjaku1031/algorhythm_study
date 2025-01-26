package baek.step.divMulPrimes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj4134 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static long N;
    public static void main(String[] args) throws IOException {
        N = Long.parseLong(br.readLine());
        while (N-- > 0) {
            long a = Long.parseLong(br.readLine());
            while (true) {
                if (isPrime(a)) {
                    sb.append(a).append("\n");
                    break;
                }
                a++;
            }

        }
        System.out.println(sb);
    }

    static boolean isPrime(long n){
        if (n <= 1) return false;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
