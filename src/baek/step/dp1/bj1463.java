package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bj1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[] count = new int[1000001];

        count[1] = 0;
        count[2] = 1;
        count[3] = 1;

        for (int i = 4; i < 1000001; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                count[i] = min(count[i / 3], count[i / 2], count[i - 1]) + 1;
            } else if (i % 3 == 0) {
                count[i] = Math.min(count[i / 3], count[i - 1]) + 1;
            } else if (i % 2 == 0) {
                count[i] = Math.min(count[i / 2], count[i - 1]) + 1;
            } else {
                count[i] = count[i - 1] + 1;
            }
        }
        System.out.println(count[a]);
        //10 -> 5 -> 4 -> 2 -> 1
        //10 -> 5 -> 4  -> 3 ->1
        //10 -> 9 -> 3 -> 1


    }

    static int min(int a, int b, int c) {
        int temp = Math.min(a, b);
        return Math.min(temp, c);
    }

}
