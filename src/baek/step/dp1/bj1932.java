package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj1932 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static List<Integer>[] tri;
    static List<Integer>[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tri = new ArrayList[N];
        dp = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            tri[i] = new ArrayList<>();
            dp[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                tri[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        //dp 시작
        dp[1].add(tri[0].get(0) + tri[1].get(0));
        dp[1].add(tri[0].get(0) + tri[1].get(1));


        for (int i = 2; i < N; i++) {
            for (int j = 0; j < tri[i].size(); j++) {
                if (j == 0) {
                    dp[i].add(dp[i - 1].get(0) + tri[i].get(0));
                } else if (j == tri[i].size() - 1) {
                    dp[i].add(dp[i - 1].get(dp[i - 1].size() - 1) + tri[i].get(j));
                } else {
                    int max = Math.max(dp[i - 1].get(j - 1), dp[i - 1].get(j));
                    dp[i].add(tri[i].get(j) + max);
                }
            }
        }
        Collections.sort(dp[N - 1]);
        System.out.println(dp[N - 1].getLast());


    }
}
