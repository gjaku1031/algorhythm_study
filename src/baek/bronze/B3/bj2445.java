package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2445 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            for (int j = 0; j < N - i; j++) {
                sb.append("  ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");

        }
        for (int i = 0; i < N; i++) {
            sb.append("**");
        }
        sb.append("\n");
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            for (int j = 0; j < N - i; j++) {
                sb.append("  ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

}
