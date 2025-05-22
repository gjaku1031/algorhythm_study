package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj18110 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] solved;
    static int N;
    static int except;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        solved = new int[N];
        for (int i = 0; i < N; i++) {
            solved[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(solved);
        except = (int)Math.round(N * 15 / 100.0);

        for (int i = 0; i < except; i++) {
            solved[i] = 0;
            solved[N - 1 - i] = 0;
        }

        int sum = 0;
        for (int i : solved) {
            sum += i;
        }
        System.out.println(Math.round(sum / (double)(N - 2 * except)));
    }
}
