package baek.step.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj25501 {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String line = br.readLine();
            count = 0;
            System.out.print(isPalindrome(line) + " " + count);
            System.out.println();
        }
    }

    static int recursion(String line, int l, int r) {
        count++;
        if (l >= r) {
            return 1;
        } else if (line.charAt(l) != line.charAt(r)) {
            return 0;
        } else {
            return recursion(line, l + 1, r - 1);
        }
    }

    static int isPalindrome(String line) {
        return recursion(line, 0, line.length() - 1);
    }
}
