package baek.step.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int base = Integer.parseInt(st.nextToken());
        System.out.println(baseConvert(num, base));
    }

    static String baseConvert(int num, int base) {
        if (base == 10) {
            return Integer.toString(num);
        } else {
            StringBuilder sb = new StringBuilder();
            int quo = num;
            int remain = 0;
            while (quo >= base) {
                remain = quo % base;
                //System.out.println("remain = " + remain);
                quo /= base;
                //System.out.println("quo = " + quo);
                sb.append(Character.forDigit(remain, base));
            }
            sb.append(Character.forDigit(quo, base));
            return sb.reverse().toString().toUpperCase();
        }

    }
}
