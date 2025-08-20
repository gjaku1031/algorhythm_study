package baek.bronze.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10996 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (N + 1) / 2; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
            for (int j = 0; j < N/2; j++) {
                System.out.print(" " + "*");
            }
            System.out.println();
        }
    }
}
