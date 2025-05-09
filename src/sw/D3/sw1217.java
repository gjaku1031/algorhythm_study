package sw.D3;

import java.util.Scanner;

public class sw1217 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = power(a, b);
            System.out.println("#" + tc + " " + result);
        }
    }

    static int power(int a, int b) {
        if (b == 0) return 1;
        return a * power(a, b - 1);
    }
}