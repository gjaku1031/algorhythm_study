package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw1208 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] boxes;

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {

            int N = Integer.parseInt(br.readLine());
            boxes = new int[100];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(st.nextToken());
            }

            int idx_max;
            int idx_min;

            int max;
            int min;

            for (int dump = 0; dump < N; dump++) {
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                idx_max = 0;
                idx_min = 0;

                for (int i = 0; i < 100; i++) {
                    if (boxes[i] > max) {
                        max = boxes[i];
                        idx_max = i;
                    }
                    if (boxes[i] < min) {
                        min = boxes[i];
                        idx_min = i;
                    }
                }

                if (max - min <= 1) {
                    break;
                }

                boxes[idx_max]--;
                boxes[idx_min]++;
            }
            Arrays.sort(boxes);
            System.out.println("#" + tc + " " + (boxes[99] - boxes[0]));
        }
    }
}
