package sw.D3;

import java.io.IOException;

public class sw3131 {
    static boolean[] isPrime = new boolean[1000001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        for (int i = 2; i <= 1000000; i++) {
            if (isPrime(i)) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
