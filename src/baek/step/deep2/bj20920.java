package baek.step.deep2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj20920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        while (N-- > 0) {
            String line = br.readLine();
            if (line.length() >= M) {
                map.put(line, map.getOrDefault(line, 0) + 1);
            }
        };


        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getKey().length() > o2.getKey().length()) {
                    return -1;
                } else if (o1.getKey().length() < o2.getKey().length()) {
                    return 1;
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        for (Map.Entry<String, Integer> stringIntegerEntry : list) {
            sb.append(stringIntegerEntry.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}