package baek.step.divMulPrimes2;

import java.io.IOException;
import java.util.Scanner;

public class bj4948 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }

    static boolean isPrime(long n){
        if (n <= 1) return false;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}