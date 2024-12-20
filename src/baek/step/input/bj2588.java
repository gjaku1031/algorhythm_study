package baek.step.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int c = b % 10;
        int d = b % 100;

        System.out.println(a * c);
        System.out.println(a * (d - c) / 10);
        System.out.println(a * (b - d) / 100);
        System.out.println(a * b);
    }
}
