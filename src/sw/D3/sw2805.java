package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = str.charAt(j) - '0';
                }
            }

            int sum = getSum(N, farm);
            System.out.println("#" + tc + " " + sum); // 결과 출력
        }
    }

    private static int getSum(int N, int[][] farm) {
        int sum = 0;
        int mid = N / 2;

        for (int i = 0; i < N; i++) {
            int startCol, endCol;
            if (i <= mid) {
                // 마름모 상반부: 중심에서 멀어질수록 범위가 넓어짐
                startCol = mid - i;
                endCol = mid + i;
            } else {
                // 마름모 하반부: 중심에서 멀어질수록 범위가 좁아짐
                int distFromBottomEdge = (N - 1) - i; // 아래 끝에서의 거리
                startCol = mid - distFromBottomEdge;
                endCol = mid + distFromBottomEdge;
            }

            // 해당 행의 마름모 범위 내 농작물 수확
            for (int j = startCol; j <= endCol; j++) {
                sum += farm[i][j];
            }
        }
        return sum;
    }
}