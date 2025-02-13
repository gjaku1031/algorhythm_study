package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj11723 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Set<Integer> set = new HashSet<>();
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                set.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("remove")) {
                set.remove(Integer.parseInt(st.nextToken()));
            } else if (command.equals("check")) {
                int current = Integer.parseInt(st.nextToken());
                if (set.contains(current)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command.equals("toggle")) {
                int current = Integer.parseInt(st.nextToken());
                if (set.contains(current)) {
                    set.remove(current);
                } else {
                    set.add(current);
                }
            } else if (command.equals("empty")) {
                set.clear();
            } else if (command.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            }
        }
        System.out.println(sb);

    }
}
