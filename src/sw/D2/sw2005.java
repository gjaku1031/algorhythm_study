package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw2005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;

    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());

            int[][] tri = new int[N][N];
            System.out.println("#" + tc);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        tri[i][j] = 1;
                        System.out.print(tri[i][j] + " ");
                    } else {
                        tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j];
                        System.out.print(tri[i][j] + " ");
                    }
                }
                System.out.println();
            }

        }
    }
}
