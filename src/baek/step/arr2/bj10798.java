package baek.step.arr2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[5];
        int[] strLen = new int[5];

        for (int i = 0; i < 5; i++) {
            str[i] = br.readLine();
            strLen[i] = str[i].length();
        }

        int Max = Arrays.stream(strLen).max().getAsInt();

        for (int i = 0; i < Max; i++) {
            for (int j = 0; j < 5; j++) {
                if (str[j].length() - 1 >= i) {
                    System.out.print(str[j].charAt(i));
                }
            }
        }

    }
}