package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw959{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] Aj = new int[N];
            int[] Bj = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                Aj[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                Bj[i] = Integer.parseInt(st.nextToken());
            }

            int result = Integer.MIN_VALUE;

            int[] shortArr, longArr;

            if (N <= M) {
                shortArr = Aj;
                longArr = Bj;
            } else {
                shortArr = Bj;
                longArr = Aj;
            }

            int shortLen = shortArr.length;
            int longLen = longArr.length;
            int diff = longLen - shortLen;


            for (int i = 0; i <= diff; i++) {
                int currentSum = 0;
                for (int j = 0; j < shortLen; j++) {
                    currentSum += shortArr[j] * longArr[i + j];
                }
                result = Math.max(result, currentSum);
            }

            if (N == 0 || M == 0) {
                result = 0;
            }

            System.out.println("#" + tc + " " + result);
        }
        br.close();
    }
}