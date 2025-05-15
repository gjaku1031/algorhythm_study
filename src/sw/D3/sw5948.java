package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class sw5948 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static Set<Integer> set;
    static int sum;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            nums = new int[7];
            set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 7; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            BTC(0, 0);

            ArrayList<Integer> list = new ArrayList<>(set);
            Collections.sort(list);

            System.out.println("#" + tc + " " + list.get(list.size()-5));
         

        }
    }

    static void BTC(int start, int level) {
        if (level == 3) {
            set.add(sum);
            return;
        }

        for (int i = start; i < 7; i++) {
            sum += nums[i];
            BTC(i + 1, level + 1);
            sum -= nums[i];
        }
    }

}
