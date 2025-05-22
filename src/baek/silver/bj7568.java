package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj7568 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] humanRank;
    static int[] weight;
    static int[] height;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        humanRank = new int[n];
        weight = new int[n];
        height = new int[n];

        for (int i = 0; i < n; i++) {
            humanRank[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (weight[i] < weight[j] && height[i] < height[j]) {

                    humanRank[i]++;
                }
            }
        }
        for (int i : humanRank) {
            System.out.print(i + " ");
        }
    }
}
