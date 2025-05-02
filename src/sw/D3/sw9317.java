package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw9317 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String str1 = br.readLine();
            String str2 = br.readLine();
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    count++;
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
