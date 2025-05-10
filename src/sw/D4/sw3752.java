package sw.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class sw3752 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;
    static int[] score;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            score = new int[N];
            set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                score[i] = Integer.parseInt(st.nextToken());
            }

            set.add(0);
            set.add(score[0]);

            for (int i = 1; i < N; i++) {
                int current = score[i];
                HashSet<Integer> sumsToAdd = new HashSet<>();
                for (Integer num : set) {
                    sumsToAdd.add(num + current);
                }
                set.addAll(sumsToAdd);
            }

            System.out.println("#" + tc + " " + set.size());
        }
    }

}
