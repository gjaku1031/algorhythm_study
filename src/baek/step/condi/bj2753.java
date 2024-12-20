package baek.step.condi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        if (isDivBy4(a) && !isDivBy100(a) || isDivBy400(a)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    static boolean isDivBy4(int a) {
        return a % 4 == 0;
    }

    static boolean isDivBy100(int a) {
        return a % 100 == 0;
    }

    static boolean isDivBy400(int a) {
        return a % 400 == 0;
    }
}
