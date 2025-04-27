package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sw1204 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            HashMap<Integer, Integer> map = new HashMap<>();

            int count = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(st.nextToken());

                map.put(score, map.getOrDefault(score, 1) + 1);
            }

            int mode_freq = 0;

            for (Integer key : map.keySet()) {
                if (mode_freq < map.get(key)) {
                    mode_freq = map.get(key);
                }
            }

            ArrayList<Integer> list = new ArrayList<>();
            for (Integer key : map.keySet()) {
                if (map.get(key) == mode_freq) {
                    list.add(key);
                }
            }

            int result = 0;
            if (list.size() == 1) {
                result = list.get(0);
            } else {
                Collections.sort(list);
                result = list.get(list.size() - 1);
            }

            System.out.println("#" + count + " " + result);

        }
    }
}
