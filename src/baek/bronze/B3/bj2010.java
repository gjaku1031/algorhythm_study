package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2010 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.isEmpty()) return;
        int n = Integer.parseInt(line.trim());

        long sum = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s == null) break;
            sum += Long.parseLong(s.trim());
        }

        long result = sum - (n - 1);
        System.out.println(result);
    }
}
