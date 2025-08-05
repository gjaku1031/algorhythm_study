package baek.silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj2961 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] ingre;
    static int N;
    static int min = Integer.MAX_VALUE;;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        ingre = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            ingre[i][0] = Integer.parseInt(st.nextToken());
            ingre[i][1] = Integer.parseInt(st.nextToken());
        }
        BTC(1, 0, 1);
        System.out.println(min);
    }

    static void BTC(int sour, int bitter, int level) {
        if (bitter != 0) {
            min = Math.min(min, Math.abs(sour - bitter));
        }
        for (int i = level; i <= N; i++) {
            BTC(sour * ingre[i][0], bitter + ingre[i][1], i + 1);
        }
    }
}