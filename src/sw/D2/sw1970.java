package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1970 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
    static int[] count;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            count = new int[8];
            for (int i = 0; i < 8; i++) {
                count[i] = N / money[i];
                N %= money[i];
            }
            System.out.println("#" + tc);
            for (int i = 0; i < 8; i++) {
                System.out.print(count[i] + " ");
            }
            System.out.println();
        }
    }
}
