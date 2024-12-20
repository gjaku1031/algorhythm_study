package baek.step.arr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj3052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] remains = new int[42];

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            remains[n % 42] = 1;
        }

        int count = 0;
        for (int i = 0; i < 42; i++) {
            if (remains[i] != 0) {
                count++;
            }
        }
        System.out.println(count);


    }
}
