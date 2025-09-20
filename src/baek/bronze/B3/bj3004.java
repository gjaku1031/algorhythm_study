package baek.bronze.B3;

import java.util.Scanner;

public class bj3004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int horizontalCuts = n / 2;
        int verticalCuts = n - horizontalCuts;

        int pieces = (horizontalCuts + 1) * (verticalCuts + 1);
        System.out.println(pieces);
    }
}
