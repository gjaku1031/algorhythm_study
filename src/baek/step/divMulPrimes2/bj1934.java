package baek.step.divMulPrimes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class bj1934 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int a, b;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            System.out.println(LCM());
        }
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int GCM() {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        int temp = 1;
        for (int i = 2; i <= big; i++) {
            if (!isPrime(i)) {
                continue;
            }
            if (big % i == 0 && small % i == 0 && temp < i) {
                temp = i;
            }
        }
        return temp;
    }

    static int LCM() {
        int x = a / GCM();
        int y = b / GCM();
        return GCM() * x * y;
    }

}
