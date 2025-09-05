package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj19539 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] trees;

    static int sum = 0;
    static String result = "NO";

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            trees[i] = now;
            sum += trees[i];
        }
        solve();
        System.out.println(result);


    }

    static void solve() {
        if (sum % 3 != 0) {
            return;
        }
        int count2 = 0;
        for (int i = 0; i < N; i++) {
            count2 += trees[i] / 2;
        }
        if (count2 >= sum / 3) {
            result = "YES";
        }
    }
}