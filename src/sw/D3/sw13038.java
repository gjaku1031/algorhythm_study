package sw.D3;

import static java.lang.Integer.MAX_VALUE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw13038 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int n;
    static int[] day;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());

            int weekCount = 0; // 주당 수업 횟수
            day = new int[7];

            // 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 7; i++) {
                day[i] = Integer.parseInt(st.nextToken());
                if (day[i] == 1) {
                    weekCount++;
                }
            }

            // 마지막주 남기고 계산
            int fullWeeks = n / weekCount;
            if (n % weekCount == 0) {
                fullWeeks--;
            }

            int remain = n - (fullWeeks * weekCount);
            int result = fullWeeks * 7;

            int minDays = MAX_VALUE;

            for (int i = 0; i < 7; i++) {

                if (day[i] == 0)
                    continue;

                int tempResult = result;
                int tempRemain = remain;
                int currentDay = i;

                // 모든 시작 요일 고려
                while (tempRemain > 0) {
                    if (day[currentDay % 7] == 1) {
                        tempRemain--;
                    }
                    tempResult++;
                    currentDay++;
                }

                minDays = Math.min(minDays, tempResult - result);
            }

            result += minDays;
            System.out.println("#" + tc + " " + result);
        }
    }
}