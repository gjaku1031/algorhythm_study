package baek.step.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj27433 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long result = 1;
        if (N != 0) {
            for (long i = N; i > 1; i--) {
                result *= i;
            }
        }
        System.out.println(result);
    }
}
