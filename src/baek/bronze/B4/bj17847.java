package baek.bronze.B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj17847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> diamonds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            diamonds.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String s1 = diamonds.get(i);
                String s2 = diamonds.get(j);

                if (s1.length() != s2.length()) {
                    continue;
                }

                String temp = s1 + s1;
                if (temp.contains(s2)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
