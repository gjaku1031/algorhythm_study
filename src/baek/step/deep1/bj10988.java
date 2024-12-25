package baek.step.deep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(isPal(str));
    }

    static int isPal(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt((str.length() - 1) - i)) {
                return 0;
            }
        }
        return 1;
    }
}
