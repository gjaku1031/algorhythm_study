package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;

public class sw1206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int totalView;

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine());
            totalView = 0;

            int[] high = new int[T];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < T; i++) {
                high[i] = Integer.parseInt(st.nextToken());
            }

            // 맨 앞2개, 맨 뒤2개는 건물없음
            for (int i = 2; i < T - 2; i++) {
                int maxNeighborHeight = 0;

                // 주변 건물 탐색
                maxNeighborHeight = Math.max(maxNeighborHeight, high[i - 2]);
                maxNeighborHeight = Math.max(maxNeighborHeight, high[i - 1]);
                maxNeighborHeight = Math.max(maxNeighborHeight, high[i + 1]);
                maxNeighborHeight = Math.max(maxNeighborHeight, high[i + 2]);

                if (high[i] > maxNeighborHeight) {
                    totalView += high[i] - maxNeighborHeight;
                }
            }
            System.out.println("#" + tc + " " + totalView);
        }
    }
}
