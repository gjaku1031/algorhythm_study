package baek.step.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        System.out.println(cons(n));
    }

    static int cons(String n) {
        for (int i = 1; i < Integer.parseInt(n); i++) {
            if ((comp(i) == Integer.parseInt(n))) {
                return i;
            }
        }
        return 0;
    }

    static int comp(int n) {
        int sum = 0;
        for (int i = 0; i < Integer.toString(n).length(); i++) {
            sum += Character.getNumericValue(
                    Integer.toString(n).charAt(i)
            );
        }
        return sum += n;
    }
}
