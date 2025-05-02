package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw4406 {
    static char[] ch = { 'a', 'e', 'i', 'o', 'u' };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            System.out.println("#" + tc + " " + remove(str));
        }
    }

    static String remove(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            boolean isVowel = false;
            for (int j = 0; j < 5; j++) {
                if (str.charAt(i) == ch[j]) {
                    isVowel = true;
                    break;
                }
            }
            if (!isVowel) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}
