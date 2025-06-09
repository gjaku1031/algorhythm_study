package baek.silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj3071 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static StringBuilder sb;
    static ArrayList<Integer> list;


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int now = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            if (now >= 0) {
                yes(now);
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (list.get(j) == -1) {
                        System.out.print("-");
                    } else {
                        System.out.print(list.get(j));
                    }
                }
                System.out.println();
            } else {
                yes((-1) * now);
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (list.get(j) == 1) {
                        System.out.print("-");
                    } else if (list.get(j) == -1) {
                        System.out.print(1);
                    } else {
                        System.out.print(list.get(j));
                    }
                }
                System.out.println();
            }
        }
    }

    static void yes(int a) {
        int now = a;
        int rest = 0;
        sb = new StringBuilder();
        while (now > 2) {
            rest = now % 3;
            now /= 3;
            list.add(rest);
        }
        list.add(now);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 2 && i < list.size() - 1) {
                list.set(i, -1);
                list.set(i + 1, list.get(i + 1) + 1);
            } else if (list.get(i) == 3 && i < list.size() - 1) {
                list.set(i, 0);
                list.set(i + 1, list.get(i + 1) + 1);
            } else if (i == list.size() - 1 && list.get(i) == 2) {
                list.add(1);
                list.set(i, -1);
            } else if (i == list.size() - 1 && list.get(i) == 3) {
                list.add(1);
                list.set(i, 0);
            }
        }


    }
}
