package baek.gold.G4;
import java.io.*;
import java.util.*;

public class bj17281 {
    static int[][] game;
    static int[] order = new int[10];
    static int N, maxScore;
    static boolean[] visited = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        game = new int[N][10];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        order[4] = 1;
        dfs(1);
        System.out.println(maxScore);
    }

    static int play() {
        int score = 0, out = 0, idx = 1;
        int[] base = new int[4];
        for (int i = 0; i < N; i++) {
            while (out < 3) {
                int hit = game[i][order[idx]];
                if (hit == 0) out++;
                else if (hit == 4) {
                    score += base[1] + base[2] + base[3] + 1;
                    Arrays.fill(base, 0);
                } else {
                    for (int j = 3; j >= 1; j--) {
                        if (base[j] == 1) {
                            if (j + hit >= 4) score++;
                            else base[j + hit] = 1;
                            base[j] = 0;
                        }
                    }
                    if (hit < 4) base[hit] = 1;
                }
                idx = idx % 9 + 1;
            }
            Arrays.fill(base, 0);
            out = 0;
        }
        return score;
    }

    static void dfs(int level) {
        if (level == 10) {
            maxScore = Math.max(maxScore, play());
            return;
        }
        for (int i = 2; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[level] = i;
                dfs(level == 3 ? level + 2 : level + 1);
                visited[i] = false;
            }
        }
    }
}
