package baek.bronze.B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                result++;
            }
        }
        System.out.println(result);
    }
}
