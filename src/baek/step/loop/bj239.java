package baek.step.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj239 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        multiple(n);
    }

    static void multiple(int n) {
        for (int i = 1; i < 10; i++) {
            System.out.println(n + " * " + i + " = " + i * n);
        }
    }
}
