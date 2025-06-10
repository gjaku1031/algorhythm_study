package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11729 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if (N % 2 == 0) {
            hanoi(N, 2);
        } else {
            hanoi(N, 3);
        }
    }

    static void hanoi(int n, int to) {
        if (n == 0) {
            return;
        }
        if (to == 2) {
            hanoi(n - 1, 3);
        } else {
            hanoi(n - 1, 2);
        }
    }
}
