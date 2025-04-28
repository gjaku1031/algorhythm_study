package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] fly = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    fly[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int size = N - M + 1;
            int max = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int sum = 0;
                    for (int k = i; k < i + M; k++) {
                        for (int l = j; l < j + M; l++) {
                            sum += fly[k][l];
                        }
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}
