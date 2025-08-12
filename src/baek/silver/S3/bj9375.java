package baek.silver.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj9375 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Set<String>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String clothes = st.nextToken();
                String category = st.nextToken();
                if (!map.containsKey(category)) {
                    map.put(category, new HashSet<String>());
                }
                map.get(category).add(clothes);
            }
            int result = 1;
            for (String s : map.keySet()) {
                result *= map.get(s).size() + 1;
            }
            System.out.println(result - 1);

        }


    }
}
