package baek.bronze.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj6996 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            ana(st.nextToken(), st.nextToken());
        }
    }

    static void ana(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        boolean flag = true;
        if (char1.length != char2.length) {
            flag = false;
        } else {
            for (int i = 0; i < char1.length; i++) {
                if (char1[i] != char2[i]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println(str1 + " & " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " & " + str2 + " are NOT anagrams.");
        }

    }
}
