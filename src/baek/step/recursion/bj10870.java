package baek.step.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        System.out.println(fibo(x));

    }

    static int fibo(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}
