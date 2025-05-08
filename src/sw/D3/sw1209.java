package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1209 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();  // 안씀..

            int result = 0;

            int diag1 = 0;  // 왼 → 오 대각
            int diag2 = 0;  // 오 → 왼 대각

            int rowSum;
            int colSum = 0;

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());

                rowSum = 0; //i마다 초기화
                for (int j = 0; j < 100; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    rowSum += num;
                    if (i == 0) colSum += num;
                    if (i == j) diag1 += num;
                    if (i + j == 99) diag2 += num;
                }
                result = Math.max(result, rowSum); //일단 행합의 최대
            }

            // 열 합
            for (int j = 0; j < 100; j++) {
                for (int i = 0; i < 100; i++) {
                    st = new StringTokenizer(br.readLine());
                    colSum += Integer.parseInt(st.nextToken());
                }
                result = Math.max(result, colSum);
            }

            result = Math.max(result, diag1);
            result = Math.max(result, diag2);

            System.out.println("#" + tc + " " + result);
        }
    }
}