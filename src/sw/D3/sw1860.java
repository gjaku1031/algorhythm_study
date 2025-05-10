package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw1860 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static int[] time;

    static int N, M, K;
    static int done;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            time = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(time);
            done = 0;
            String result = "Possible";
            for (int i = 0; i < N; i++) {
                if (rest_bread(time[i]) <= 0) {
                    result = "Impossible";
                } else {
                    done++;
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }

    static int rest_bread(int currentTime) {
        return currentTime / M * K - done;
    }

}
