package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[5];

            while (true) {
                if (num % 2 == 0) {
                    arr[0]++;
                    num /= 2;
                } else {
                    break;
                }
            }

            while (true) {
                if (num % 3 == 0) {
                    arr[1]++;
                    num /= 3;
                } else {
                    break;
                }
            }

            while (true) {
                if (num % 5 == 0) {
                    arr[2]++;
                    num /= 5;
                } else {
                    break;
                }
            }

            while (true) {
                if (num % 7 == 0) {
                    arr[3]++;
                    num /= 7;
                } else {
                    break;
                }
            }

            while (true) {
                if (num % 11 == 0) {
                    arr[4]++;
                    num /= 11;
                } else {
                    break;
                }
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < 5; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");
        }

    }
}