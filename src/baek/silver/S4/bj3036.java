package baek.silver.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3036 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] radius;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        radius = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            radius[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int a = radius[0];
            int b = radius[i];
            int gcd = GCD(a, b);
            System.out.println(a / gcd + "/" + b / gcd);
        }
    }

    static int GCD(int a, int b) {
        int gcd = 1;
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
