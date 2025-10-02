package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class bj2935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 수 입력
        BigInteger A = new BigInteger(br.readLine());

        // 연산자 입력
        String operator = br.readLine();

        // 두 번째 수 입력
        BigInteger B = new BigInteger(br.readLine());

        // 연산자에 따라 계산
        BigInteger result;
        if (operator.equals("+")) {
            result = A.add(B);
        } else {
            result = A.multiply(B);
        }

        // 결과 출력
        System.out.println(result);

        br.close();
    }
}
