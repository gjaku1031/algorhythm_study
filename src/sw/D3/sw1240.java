package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1240 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static int N, M;
    static String code;
    static int result;


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            input();
            decode(tc);
        }
    }

    static void input() throws IOException {
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = str.length() - 1; j >= 0; j--) {
                if (str.charAt(j) == '1') {
                    code = str.substring(j - 55, j); //찾으면 메서드 종료
                    return;
                }
            }
        }
    }

    static void decode(int tc) {
        for (int i = 0; i < 8; i++) {
            String sub = code.substring(i * 7, (i + 1) * 7);
            int a = calculate(sub);
            if (a == -1) {
                System.out.println("#" + tc + " " + result);
            }
        }
    }

    static int calculate(String sub) {
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            if (i % 2 == 0) {
                sum += Integer.parseInt(Character.toString(sub.charAt(i))) * 3;
            } else {
                sum += Integer.parseInt(Character.toString(sub.charAt(i)));
            }
        }
        if (sum % 10 == 0) {
            return sum;
        } else {
            return -1;
        }
    }
}