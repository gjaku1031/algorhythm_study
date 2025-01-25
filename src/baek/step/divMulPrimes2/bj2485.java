package baek.step.divMulPrimes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2485 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] trees;
    static int[] gap;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        trees = new int[N];
        gap = new int[N - 1];

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(trees);

        for (int i = 0; i < N - 1; i++) {
            gap[i] = trees[i + 1] - trees[i];
        }

        int commonGap= gap[0];
        for (int i = 0; i < N - 1; i++) {
            commonGap = Euclidean(commonGap, gap[i]);
        }
        System.out.println(((trees[N - 1] - trees[0]) / commonGap) + 1 - N);

    }
    static int Euclidean(int a, int b) {
        if (b == 0)
            return a;
        return Euclidean(b, a % b);
    }
}