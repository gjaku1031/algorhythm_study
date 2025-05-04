package baek.step.dp1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1912 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int max = arr[0];


        /*
         i 번째 원소까지 고려했을 때, 다음 단계(i+1)를 위해 어떤 정보를 저장해야 할까 -> 이를 고민
            - 이 문제에서는 i번째 원소를 반드시 포함하는 연속 부분 배열 중 합이 최대인 값을 아는 것이 중요
            -> arr[i+1] 혼자서 새로운 연속 부분 배열을 시작
            -> 또는, arr[i]로 끝나는 최대 연속 부분 배열에 arr[i+1]을 이여 붙여 더 큰 합을 만들 수 있는가
         */
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}