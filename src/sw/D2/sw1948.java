package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class sw1948 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<Integer, Integer> cal = new HashMap<>();

        cal.put(1, 31);
        cal.put(2, 28);
        cal.put(3, 31);
        cal.put(4, 30);
        cal.put(5, 31);
        cal.put(6, 30);
        cal.put(7, 31);
        cal.put(8, 31);
        cal.put(9, 30);
        cal.put(10, 31);
        cal.put(11, 30);
        cal.put(12, 31);


        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int mon1 = Integer.parseInt(st.nextToken());
            int day1 = Integer.parseInt(st.nextToken());

            int mon2 = Integer.parseInt(st.nextToken());
            int day2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int i = mon1; i <= mon2; i++) {
                sum += cal.get(i);
            }

            sum -= day1 - 1;
            sum -= cal.get(mon2) - day2;

            System.out.println("#" + tc + " " + sum);
        }
    }
}
