package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class sw1209 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {

        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());

            //입력
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] rows = new int[100];
            int[] cols = new int[100];
            int x = 0;
            int y = 0;

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    rows[i] += arr[i][j];
                    cols[i] += arr[j][i];
                }
            }

            for (int i = 0; i < 100; i++) {
                x += arr[i][i];
                y += arr[i][99 - i];
            }

            Arrays.sort(rows);
            Arrays.sort(cols);

            int max = Math.max(rows[99], cols[99]);
            max = Math.max(max, x);
            max = Math.max(max, y);

            System.out.println("#" + tc + " " + max);

        }
    }
}
