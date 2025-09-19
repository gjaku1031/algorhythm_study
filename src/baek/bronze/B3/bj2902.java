package baek.bronze.B3;

import java.util.Scanner;

public class bj2902 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String[] parts = input.split("-");

        for (String part : parts) {
            System.out.print(part.charAt(0));
        }
    }
}
