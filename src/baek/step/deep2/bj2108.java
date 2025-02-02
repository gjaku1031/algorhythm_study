package baek.step.deep2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class bj2108 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        Arrays.sort(arr);

        double sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println((int) Math.round(sum / N));

        System.out.println(arr[(int) (N / 2)]);


        int mode = map.get(arr[0]);
        for (Integer i : map.keySet()) {
            if (mode < map.get(i)) {
                mode = map.get(i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) == mode) {
                list.add(i);
            }
        }


        if (list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            Collections.sort(list);
            System.out.println(list.get(1));
        }



        System.out.println(arr[N - 1] - arr[0]);

    }
}
