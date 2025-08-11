package baek.bronze.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj2309 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr = new int[9];
    static List<Integer> list = new ArrayList<>();
    static int sum = 0;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        BTC(0, 0);
    }

    static void BTC(int start, int level) {
        if (level == 7) {
            if (sum == 100 && !flag) {
                flag = true;
                for (Integer i : list) {
                    System.out.println(arr[i]);
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            list.add(i);
            sum += arr[i];
            BTC(start + 1, level + 1);
            list.remove(list.size() - 1);
            sum -= arr[i];
        }
    }
}
