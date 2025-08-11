package sw.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sw4008 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static List<Integer> oper;
    static List<Integer> order;
    static int N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            oper = new ArrayList<>();
            order = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                int a = Integer.parseInt(st.nextToken());
                for (int j = 0; j < a; j++) {
                    oper.add(i);
                }
            }
            bt(0);
            System.out.println("#" + tc + " ");
        }
    }

    static void bt(int level) {
        if (level == 7) {
            for (Integer i : order) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            order.add(oper.get(i));
            bt(level + 1);
            order.remove(order.size() - 1);
        }
    }
}