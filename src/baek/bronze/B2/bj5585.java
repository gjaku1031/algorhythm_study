package baek.bronze.B2;

import java.util.Scanner;

public class bj5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int payment = sc.nextInt();
        int change = 1000 - payment;

        int[] coins = {500, 100, 50, 10, 5, 1};
        int count = 0;

        for (int coin : coins) {
            count += change / coin;
            change %= coin;
        }

        System.out.println(count);
        sc.close();
    }
}
