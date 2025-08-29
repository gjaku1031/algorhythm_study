package baek.silver.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2527 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        for (int tc = 0; tc < 4; tc++) {
            int[][] sq = new int[2][4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    sq[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int overlapR;
            int overlapC;

        }
    }
}