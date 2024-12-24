package baek.step.deep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //N행까지 출력
        for (int i = 0; i < N; i++) {
            // i행 공백출력
            for (int j = 0; j < N - 1 - i; j++) {
                System.out.print(" ");
            }
            // i행 *출력
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * (N - i) - 1; j++) {
                System.out.print("*");
            }
            //마지막 줄 공백 없애기
            if (i != N - 1) {
                System.out.println();
            }
        }
    }
}
