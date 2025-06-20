package baek.silver.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class bj15663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder result = new StringBuilder();
    static StringBuilder sb;
    static int N, M;
    static int[] nums;
    static Set<String> past = new HashSet<>();
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        BTC(0, 0);
        System.out.println(result);

    }

    static void BTC(int start, int level) {
        if (level == M) {
            sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(list.get(i)).append(" ");
            }
            String now = sb.toString();
            if (!past.contains(now)) {
                past.add(now);
                result.append(now).append("\n");
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                BTC(start, level + 1);
                visited[i] = false;
                list.remove(level);
            }
        }
    }
}
