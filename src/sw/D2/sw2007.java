package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw2007 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            int result = 0;
            for (int i = 1; i <= 10; i++) {
                String sub = str.substring(0, i);
                if (sub.equals(str.substring(i, i + i))) {
                    result = i;
                    break;
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
