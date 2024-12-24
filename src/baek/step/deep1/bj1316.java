package baek.step.deep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            sum += isGroup(str);
        }
        System.out.println(sum);
    }

    static int isGroup(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                continue;
            }
            for (int j = i; j < str.length() - 2; j++) {
                if (str.charAt(i) == str.charAt(j + 2)) {
                    count++;
                }
            }
        }
        return count == 0 ? 1 : 0;
    }
}
