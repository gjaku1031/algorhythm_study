package baek.step.setMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Optional;
import java.util.StringTokenizer;

public class bj10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> numCount = new HashMap<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st1.nextToken());
            numCount.put(n, numCount.getOrDefault(n, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int m = Integer.parseInt(st2.nextToken());
            result.append(Optional.ofNullable(numCount.get(m)).orElse(0)).append(" ");
        }
        System.out.println(result);
    }
}
