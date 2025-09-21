package baek.bronze.B4;

import java.util.Scanner;

public class bj5596 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minguk_total = 0;
        for (int i = 0; i < 4; i++) {
            minguk_total += sc.nextInt();
        }

        int manse_total = 0;
        for (int i = 0; i < 4; i++) {
            manse_total += sc.nextInt();
        }

        System.out.println(Math.max(minguk_total, manse_total));
    }
}
