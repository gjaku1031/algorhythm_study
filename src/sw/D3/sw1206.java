package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw1206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine());

            int[][] coordinate = new int[T][255];
            int[] high = new int[T];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < T; i++) {
                high[i] = Integer.parseInt(st.nextToken());
                for (int j = 0; j < high[i]; j++) {
                    coordinate[i][j] = 1;
                }
            }

            for (int i = 0; i < T; i++) {
                if (i == 0) {
                    for (int j = 0; j < high[0]; j++) {
                        if (coordinate[i][j] == 1) {
                        }
                    }
                }
            }
        }
    }
}
