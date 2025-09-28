package baek.bronze.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj14624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 짝수인 경우
        if (n % 2 == 0) {
            System.out.println("I LOVE CBNU");
        }
        // 홀수인 경우 - 전북대학교 로고 모양 출력
        else {
            // 첫 번째 줄 - 별 n개
            for (int i = 0; i < n; i++) {
                sb.append('*');
            }
            sb.append('\n');

            // 두 번째 줄부터 - V자 모양
            int mid = n / 2;  // 중간 위치

            for (int i = 0; i <= mid; i++) {
                // 왼쪽 공백
                for (int j = 0; j < mid - i; j++) {
                    sb.append(' ');
                }

                // 왼쪽 별
                sb.append('*');

                // 가운데 공백
                if (i > 0) {
                    for (int j = 0; j < 2 * i - 1; j++) {
                        sb.append(' ');
                    }
                    // 오른쪽 별
                    sb.append('*');
                }

                sb.append('\n');
            }

            System.out.print(sb);
        }

        br.close();
    }
}
