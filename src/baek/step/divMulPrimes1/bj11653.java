package baek.step.divMulPrimes1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int divisor = 2;

        while (!isPrime(N)) {
            if (N % divisor == 0) {
                N /= divisor;
                System.out.println(divisor);
            } else {
                divisor++;
            }
        }
        System.out.println(N);
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
