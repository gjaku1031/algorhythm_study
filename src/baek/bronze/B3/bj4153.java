package baek.bronze.B3;

import java.util.Arrays;
import java.util.Scanner;

public class bj4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            if (arr[2] == 0) {
                break;
            }
            isRightTri(arr);
        }
        sc.close();
    }

    static void isRightTri(int[] arr) {
        if (Math.pow(arr[2], 2) == Math.pow(arr[1], 2) + Math.pow(arr[0], 2)) {
            System.out.println("right");
        } else {
            System.out.println("wrong");
        }
    }
}