package baek.silver.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2527 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] square;
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            square = new int[4][2];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                square[i][0] = Integer.parseInt(st.nextToken());
                square[i][1] = Integer.parseInt(st.nextToken());
            }
        }
    }
}