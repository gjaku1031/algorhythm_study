package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1541 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int sum = Integer.MAX_VALUE;
        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");


        while (sub.hasMoreTokens()) {
            int temp = 0;
            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");

            while (add.hasMoreTokens()) {
                temp += Integer.parseInt(add.nextToken());
            }

            //처음 숫자에서 이어지는 덧셈
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
