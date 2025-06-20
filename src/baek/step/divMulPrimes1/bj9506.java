package baek.step.divMulPrimes1;

import java.util.Scanner;

public class bj9506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == -1) {
                break;
            }
            isPerfect(n);
        }
        sc.close();
    }

    static void isPerfect(int n) {
        StringBuilder sb = new StringBuilder(n + " = 1");
        int sum = 1;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                sb.append(" + " + i);
                sum += i;
            }
        }

        if (sum == n) {
            System.out.println(sb);
        } else {
            System.out.println(n + " is NOT perfect.");
        }
    }

    static void factor(int x, int y) {
        if (y % x == 0) {
            System.out.println("factor");
        } else {
            System.out.println("neither");
        }
    }

}
