package baek.step.divMulPrimes;
import java.util.Scanner;

public class bj5086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 0 && y == 0) {
                break;
            }
            if (x < y) {
                factor(x, y);
            } else {
                multi(x, y);
            }

        }
    }

    static void factor(int x, int y) {
        if (y % x == 0) {
            System.out.println("factor");
        } else {
            System.out.println("neither");
        }
    }

    static void multi(int x, int y) {
        if (x % y == 0) {

            System.out.println("multiple");
        } else {
            System.out.println("neither");
        }
    }
}
