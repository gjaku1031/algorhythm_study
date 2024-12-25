package baek.step.deep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(pal(str));
    }
    static int pal(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (str.charAt(i) == 'c' && i < str.length() - 1) {
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }
            }
            if (str.charAt(i) == 'l' && i < str.length() - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            }
            if (str.charAt(i) == 'n' && i < str.length() - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            }
            if (str.charAt(i) == 's' && i < str.length() - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }
            if (str.charAt(i) == 'z' && i < str.length() - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }
            if (str.charAt(i) == 'd' && i < str.length() - 1) {
                if (str.charAt(i + 1) == '-') {
                    i++;
                }
            }
            if (str.charAt(i) == 'd' && i < str.length() - 2) {
                if (str.charAt(i + 1) == 'z') {
                    if (str.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            }
        }
        return count;
    }
}
