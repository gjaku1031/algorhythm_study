package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1932 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] triangle; // 입력은 여전히 2D 필요
    static int[] dp; // O(N) 공간 DP 배열

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        triangle = new int[N][N];
        dp = new int[N]; // 이전 행의 최대합 저장용

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값 (첫 번째 행)
        dp[0] = triangle[0][0];

        // DP 계산 (두 번째 행부터)
        for (int i = 1; i < N; i++) {
            // 뒤에서부터 계산해야 이전 행의 값이 덮어쓰여지기 전에 사용 가능
            for (int j = i; j >= 0; j--) {
                int currentVal = triangle[i][j];
                if (j == i) { // 오른쪽 끝: 이전 행의 오른쪽 끝(j-1)에서만 옴
                    dp[j] = dp[j - 1] + currentVal;
                } else if (j == 0) { // 왼쪽 끝: 이전 행의 왼쪽 끝(j)에서만 옴
                    dp[j] = dp[j] + currentVal;
                } else { // 중간: 이전 행의 왼쪽 위(j-1) 또는 바로 위(j) 중 큰 값에서 옴
                    dp[j] = Math.max(dp[j - 1], dp[j]) + currentVal;
                }
            }
        }

        // 최종 결과 (dp 배열에 마지막 행의 결과가 저장되어 있음)
        int maxResult = 0;
        for (int k = 0; k < N; k++) {
            maxResult = Math.max(maxResult, dp[k]);
        }
        // 또는 Arrays.stream(dp).max().getAsInt(); 사용 가능 (N=0인 경우 주의)

        System.out.println(maxResult);
    }
}