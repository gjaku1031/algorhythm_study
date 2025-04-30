package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            int result = 1;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    result = 0;
                }
            }
            System.out.println("#" + tc + " " + result);
        }

    }
}
