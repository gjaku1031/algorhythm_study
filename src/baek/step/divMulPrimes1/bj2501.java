package baek.step.divMulPrimes1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isFactor(N, i)) {
                count++;
                if (count == K) {
                    System.out.println(i);
                    break;
                }
            }
        }
        if (count < K) {
            System.out.println(0);
        }

    }

    static boolean isFactor(int num, int div) {
        return num % div == 0;
    }
}
