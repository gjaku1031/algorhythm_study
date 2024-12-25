package baek.step.deep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj25084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] myChess = new int[6];
        int[] chess = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < 6; i++) {
            myChess[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 6; i++) {
            System.out.print((chess[i] - myChess[i]) + " ");
        }
    }
}
