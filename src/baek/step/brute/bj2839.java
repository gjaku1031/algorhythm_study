package baek.step.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = equation(n);
        System.out.println(result);
    }

    static int equation(int n) {
        int x = 0;
        int y = 0;
        int min = -1;
        for (int i = 0; true; i++) {
            x = i;

            // y가 정수인지 확인 아니면 하위 명령 실행x
            if ((n - 3 * x) % 5 == 0) {
                y = (n - 3 * x) / 5;
            } else {
                continue;
            }

            // y가 음수면 for 문 종료
            if (y < 0) {
                break;
            }
            if (min > x + y || min == -1) {
                min = x + y;
            }
        }
        return min;
    }
}
// 3x + 5y = n