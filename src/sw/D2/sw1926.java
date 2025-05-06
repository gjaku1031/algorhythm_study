package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1926 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            check(i);
        }
        System.out.println(sb);
    }

    static void check(int i) {
        String str = Integer.toString(i);
        boolean bool = false;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                sb.append("-");
                bool = true;
            }
        }
        if (!bool) {
            sb.append(i).append(" ");
        } else {
            sb.append(" ");
        }

    }
}
