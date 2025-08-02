package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int groupCount = Math.min(N, M) / 2;

        for (int i = 0; i < groupCount; i++) {
            int perimeter = 2 * (N - 2 * i) + 2 * (M - 2 * i) - 4;
            int rotateCount = R % perimeter;

            for (int r = 0; r < rotateCount; r++) {
                int temp = arr[i][i]; // 시작 위치 값 임시 저장

                // 위쪽 변 이동 (왼쪽으로)
                for (int j = i; j < M - i - 1; j++) {
                    arr[i][j] = arr[i][j + 1];
                }

                // 오른쪽 변 이동 (위쪽으로)
                for (int j = i; j < N - i - 1; j++) {
                    arr[j][M - i - 1] = arr[j + 1][M - i - 1];
                }

                // 아래쪽 변 이동 (오른쪽으로)
                for (int j = M - i - 1; j > i; j--) {
                    arr[N - i - 1][j] = arr[N - i - 1][j - 1];
                }

                // 왼쪽 변 이동 (아래쪽으로)
                for (int j = N - i - 1; j > i; j--) {
                    arr[j][i] = arr[j - 1][i];
                }

                arr[i + 1][i] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}