package baek.gold.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11444 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long N;
    static long[] fibo = {1, 1, 1, 0};

    public static void main(String[] args) throws IOException {
        N = Long.parseLong(br.readLine());
        long[] result = recur(fibo, N);
        System.out.println(result[2]);
    }

    static long[] recur(long[] mat, long n) {
        if (n == 1) {
            return mat;
        }

        long[] now = recur(mat, n / 2);
        long[] squared = multi(now, now);
        if (n % 2 == 1) {
            return multi(squared, fibo);
        }
        return squared;
    }

    static long[] multi(long[] mat1, long[] mat2) {
        long[] next_mat = new long[4];
        next_mat[0] = (mat1[0] * mat2[0] + mat1[1] * mat2[2]) % 1000000007;
        next_mat[1] = (mat1[0] * mat2[1] + mat1[1] * mat2[3]) % 1000000007;
        next_mat[2] = (mat1[2] * mat2[0] + mat1[3] * mat2[2]) % 1000000007;
        next_mat[3] = (mat1[2] * mat2[1] + mat1[3] * mat2[3]) % 1000000007;
        return next_mat;
    }
}