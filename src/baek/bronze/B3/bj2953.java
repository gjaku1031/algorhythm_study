package baek.bronze.B3;

import java.util.Scanner;

public class bj2953 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxScore = 0;
        int winner = 0;

        for (int i = 1; i <= 5; i++) {
            int currentScore = 0;
            for (int j = 0; j < 4; j++) {
                currentScore += scanner.nextInt();
            }
            if (currentScore > maxScore) {
                maxScore = currentScore;
                winner = i;
            }
        }
        System.out.println(winner + " " + maxScore);
        scanner.close();
    }
}
