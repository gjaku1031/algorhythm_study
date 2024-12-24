package baek.step.deep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 모두 대문자로 바꾸기
        String upStr = str.toUpperCase();
        int[] alp = new int[26];
        // 배열에 값 넣기
        for (int i = 0; i < str.length(); i++) {
            alp[((int) upStr.charAt(i)) - 65]++;
        }
        // 최대 찾기
        int max = Arrays.stream(alp).max().getAsInt();
        // max 값 중복된 인덱스 체크
        if (nestCheck(alp, max)) {
            System.out.println("?");
        } else {
            for (int i = 0; i < 26; i++) {
                if (alp[i] == max) {
                    System.out.println((char) (65 + i));
                    break;
                }
            }
        }
    }
    static boolean nestCheck(int[] arr, int num) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            }
            if (count == 2) {
                return true;
            }
        }
        return false;
    }
}
