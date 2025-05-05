package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1976 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            int resultHour = h1 + h2;
            int resultMin = m1 + m2;

            resultHour = resultHour + resultMin / 60;
            resultMin %= 60;
            resultHour %= 12;
            if (resultHour == 0) {
                resultHour = 12;
            }

            System.out.println("#" + tc + " " + resultHour + " " + resultMin);
        }
    }

}
