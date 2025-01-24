package baek.step.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14889 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int totalPlayer;
    static int[][] player;
    static int[] players;
    static int sum;
    static int tempSum;
    static int N;
    static int min;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        player = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sum = 0;
        totalPlayer = (N * N - N) / 2;
        players = new int[totalPlayer];
        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                int a = player[i][j] + player[j][i];
                players[count++] = a;
            }
        }
        for (int i = 0; i < totalPlayer; i++) {
            sum += players[i];
        }
        min = sum;


    }

    static void BTC(int start, int depth) {
        if (depth == totalPlayer / 2) {
            min=Math.min(min,Math.abs())
            return;
        }

        for (int i = start; i < totalPlayer; i++) {
            tempSum += players[i];
            BTC(start + 1, depth);
            tempSum -= players[i];
        }
    }
}
