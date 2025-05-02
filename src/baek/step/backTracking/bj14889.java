package baek.step.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj14889 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<Integer> team = new HashSet<>();
    static int min=Integer.MAX_VALUE;
    static StringTokenizer st;
    static int[][] player;
    static int N;



    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        player = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BTC(0, 0);
        System.out.println(min);
    }

    static void BTC(int start, int depth) {
        if (depth == N / 2) {
            int teams1score = 0;
            int teams2score = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (team.contains(i) && team.contains(j)) {
                        teams1score += player[i][j];
                        teams1score += player[j][i];
                    } else if (!team.contains(i) && !team.contains(j)) {
                        teams2score += player[i][j];
                        teams2score += player[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(teams1score - teams2score));
            return;
        }

        for (int i = start; i < N; i++) {
            team.add(i);
            BTC(i + 1, depth + 1);
            team.remove(i);
        }
    }
}