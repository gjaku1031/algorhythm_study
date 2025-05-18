package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw10580 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static int[] arr1;
    static int[] arr2;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            arr1 = new int[N];
            arr2 = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr1[i] = Integer.parseInt(st.nextToken());
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if ((arr1[i] - arr1[j]) * (arr2[i] - arr2[j]) < 0) {
                        result++;
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }

}
