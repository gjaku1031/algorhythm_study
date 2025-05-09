package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1213 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count;

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            count = 0;
            String str1 = br.readLine();
            String str2 = br.readLine();
            compareString(str1,str2);
            System.out.println("#" + tc + " " + count);
        }
    }

    static void compareString(String str1, String str2) {
        char check = str1.charAt(0);
        for (int i = 0; i <= str2.length() - str1.length(); i++) {
            if (str2.charAt(i) == check && str2.startsWith(str1, i)) {
                count++;
            }
        }
    }
}
