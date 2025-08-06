package baek.gold.G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11401 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;

    static final int MOD = 1000000007;
    static final int MAX = 4_000_000;
    static long[] fact = new long[MAX];
    static long[] inv = new long[MAX];

    public static void main(String[] args) throws IOException {
        precompute();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(nCr(N, K));
    }

    static void precompute() {
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        inv[MAX - 1] = power(fact[MAX - 1], MOD - 2, MOD);
        for (int i = MAX - 2; i >= 0; i--) {
            inv[i] = (inv[i + 1] * (i + 1)) % MOD;
        }
    }

    static long nCr(int n, int r) {
        if (r > n || r < 0) {
            return 0;
        }

        return (fact[n] * inv[r] % MOD) * inv[n - r] % MOD;
    }

    static long power(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

}