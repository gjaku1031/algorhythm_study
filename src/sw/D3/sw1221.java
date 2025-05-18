package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class sw1221 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<Number> nums;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        map.put("ZRO", 0);
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THR", 3);
        map.put("FOR", 4);
        map.put("FIV", 5);
        map.put("SIX", 6);
        map.put("SVN", 7);
        map.put("EGT", 8);
        map.put("NIN", 9);

        for (int tc = 1; tc <= T; tc++) {
            nums = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            String tc_str = st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String now = st.nextToken();
                nums.add(new Number(now, map.get(now)));
            }
            Collections.sort(nums);

            System.out.println(tc_str);
            for (Number num : nums) {
                System.out.print(num.getName()+" ");
            }
            System.out.println();
        }
    }

    static class Number implements Comparable<Number> {
        String name;
        int num;

        public Number(String name, int num) {
            this.name = name;
            this.num = num;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Number o) {
            return this.num - o.num;
        }
    }
}