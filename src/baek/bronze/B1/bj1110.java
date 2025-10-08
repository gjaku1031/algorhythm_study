package baek.bronze.B1;

import java.io.*;

public class bj1110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line.trim());

        int orig = n;
        int cnt = 0;
        int x = n;

        do {
            int a = x / 10;
            int b = x % 10;
            int s = a + b;
            x = b * 10 + (s % 10);
            cnt++;
        } while (x != orig);

        System.out.println(cnt);
    }
}
