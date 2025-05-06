package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw1983 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int student = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[i] = a * 35 + b * 45 + c * 20;
            }

            int[] rank = arr.clone();
            int a = N / 10;
            Arrays.sort(rank);
            int targetScore = arr[student - 1];
            int idx = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (rank[i] == targetScore) {
                    idx = N - 1 - i;
                    break;
                }
            }
            System.out.println("#" + tc + " " + grade[idx / a]);
        }
    }
}
