package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            System.out.println("#" + tc + " " + zig(Integer.parseInt(br.readLine())));
        }
    }

    static int zig(int N) {
        if (N % 2 == 0) {
            return N / 2 * (-1);
        } else {
            return (N - 1) / 2 * (-1) + N;
        }
    }
}
