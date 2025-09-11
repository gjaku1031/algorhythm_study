package sw.D4;

import java.util.Scanner;

public class sw5643 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            boolean[][] reach = new boolean[N][N];

            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                reach[a - 1][b - 1] = true;
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    if (!reach[i][k]) continue;
                    for (int j = 0; j < N; j++) {
                        if (reach[k][j]) reach[i][j] = true;
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                int known = 0;
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    if (reach[i][j] || reach[j][i]) known++;
                }
                if (known == N - 1) answer++;
            }

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(answer)
                    .append('\n');
        }

        System.out.print(sb);
    }
}
