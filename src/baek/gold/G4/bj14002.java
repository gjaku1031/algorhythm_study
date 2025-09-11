package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14002 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] seq, dp, parent;

    static int bestLen = 1, bestEnd = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        seq = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        parent = new int[N];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > bestLen) {
                bestLen = dp[i];
                bestEnd = i;
            }
        }

        int[] result = new int[bestLen];
        for (int i = bestLen - 1, cur = bestEnd ; i >= 0; i--) {
            result[i] = seq[cur];
            cur = parent[cur];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bestLen).append("\n");
        for(int x : result) sb.append(x).append(' ');
        System.out.println(sb);
    }
}
