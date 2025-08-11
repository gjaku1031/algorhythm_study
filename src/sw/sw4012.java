package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw4012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N;
    static int[][] cook;
    static int[] nums;
    static int min;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            cook = new int[N + 1][N + 1];
            nums = new int[N + 1];
            min = Integer.MAX_VALUE;

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    cook[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            BTC(1, 0);
            System.out.println("#" + tc + " " + min);
        }
    }

    static void BTC(int start, int level) {
        if (level == N / 2) {
            int temp1 = 0;
            int temp2 = 0;
            for (int i = 1; i < N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (nums[i] == 1 && nums[j] == 1) {
                        temp1 += cook[i][j];
                        temp1 += cook[j][i];
                    }

                    if (nums[i] == 0 && nums[j] == 0) {
                        temp2 += cook[i][j];
                        temp2 += cook[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(temp1 - temp2));
            return;
        }

        for (int i = start; i <= N; i++) {
            nums[i] = 1;
            BTC(i + 1, level + 1);
            nums[i] = 0;
        }
    }
}