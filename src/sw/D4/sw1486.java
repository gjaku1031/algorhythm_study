package sw.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class sw1486 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N, B;
    static Integer[] stuffs;

    static int sum = 0;
    static int answer;

    static void dfs(int idx) {
        if (sum >= B) {
            if (sum < answer) answer = sum;
            return;
        }
        if (idx == N) return;
        if (sum >= answer) return;
        sum += stuffs[idx];
        dfs(idx + 1);
        sum -= stuffs[idx];
        dfs(idx + 1);
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            stuffs = new Integer[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                stuffs[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(stuffs, Collections.reverseOrder());
            answer = Integer.MAX_VALUE;
            sum = 0;
            dfs(0);

            System.out.println("#" + tc + " " + (answer - B));
        }
    }

}