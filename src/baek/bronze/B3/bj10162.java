package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10162 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int[] button = new int[3];
        button[0] = T / 300;
        T %= 300;

        button[1] = T / 60;
        T %= 60;

        button[2] = T / 10;
        T %= 10;

        if (T != 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.print(button[i] + " ");
            }
        }
    }
}
