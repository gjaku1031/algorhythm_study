package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2023 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr_first = { 2, 3, 5, 7 };
    static int[] arr_odd = { 1, 3, 5, 7, 9 };
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < 4; i++) {
            BTC(arr_first[i], 1);
        }
    }

    static void BTC(int now, int level) {
        if (level == N) {
            System.out.println(now);
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (isPrime(now * 10 + arr_odd[i])) {
                //System.out.println("now * 10 + arr_odd[i] = " + (now * 10 + arr_odd[i]));
                BTC(now * 10 + arr_odd[i], level + 1);
            }
        }
    }

    static boolean isPrime(int n) {
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
}