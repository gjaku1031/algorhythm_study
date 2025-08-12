package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj17281 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] baseball;
    static int[] inning = new int[10];
    static int N;

    static boolean[] visited = new boolean[10];
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        baseball = new int[N][10];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                baseball[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        inning[4] = 1;
        DFS(1);
        System.out.println(result);
    }

    static int play() {
        int score = 0;
        int out_count = 0;
        int idx = 1;

        int[] base = new int[4];
        for (int i = 0; i < N; i++) {
            while (out_count < 3) {
                if (baseball[i][inning[idx]] == 1) {
                    // 3루에 사람 있으면 홈인 + 점수 up
                    if (base[3] == 1) {
                        score += 1;
                        base[3] = 0;
                    }

                    // 2루에 사람 있으면 옮기기
                    if (base[2] == 1) {
                        base[3] = 1;
                        base[2] = 0;
                    }

                    // 1루에 사람 있으면 옮기기
                    if (base[1] == 1) {
                        base[2] = 1;
                        base[1] = 0;
                    }
                    // 1루에 주자 ㄱ
                    base[1] = 1;
                } else if (baseball[i][inning[idx]] == 2) {
                    if (base[3] == 1) {
                        score += 1;
                        base[3] = 0;
                    }

                    // 2루에 사람 있으면 옮기기
                    if (base[2] == 1) {
                        score += 1;
                        base[2] = 0;
                    }

                    // 1루에 사람 있으면 옮기기
                    if (base[1] == 1) {
                        base[3] = 1;
                        base[1] = 0;
                    }
                    // 2루에 주자 ㄱ
                    base[2] = 1;

                } else if (baseball[i][inning[idx]] == 3) {

                    if (base[3] == 1) {
                        score += 1;
                        base[3] = 0;
                    }

                    // 2루에 사람 있으면 옮기기
                    if (base[2] == 1) {
                        score += 1;
                        base[2] = 0;
                    }

                    // 1루에 사람 있으면 옮기기
                    if (base[1] == 1) {
                        score += 1;
                        base[1] = 0;
                    }
                    base[3] = 1;

                } else if (baseball[i][inning[idx]] == 4) {
                    // 홈런
                    int count = 0;
                    for (int j = 1; j < 4; j++) {
                        if (base[j] == 1) {
                            count++;
                        }
                    }
                    score += (count + 1);
                    Arrays.fill(base, 0);
                } else {
                    out_count++;
                }
                idx = (idx + 1) % 10;
                if (idx == 0) idx++;
            }
            Arrays.fill(base, 0);
            out_count = 0;
        }
        return score;
    }

    static void DFS(int level) {
        if (level == 10) {
            int now_score = play();
            result = Math.max(result, now_score);
            return;
        }

        for (int i = 2; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                inning[level] = i;

                if (level == 3) {
                    DFS(level + 2);
                } else {
                    DFS(level + 1);
                }
                visited[i] = false;
            }
        }
    }
}
