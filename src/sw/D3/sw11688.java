package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw11688 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            int a = 1;
            int b = 1;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'L') {
                    b += a;
                } else {
                    a += b;
                }
            }
            System.out.println("#" + tc + " " + a + " " + b);
        }

    }
}
