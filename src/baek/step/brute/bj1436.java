package baek.step.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; true; i++) {
            if (isDeathNum(i)) {
                count++;
            }
            if (count == n) {
                System.out.println(i);
                break;
            }
        }
    }

    static boolean isDeathNum(int n) {
        if (n < 100) {
            return false;
        } else {
            String s = Integer.toString(n);
            return s.contains("666");
        }
    }
}
