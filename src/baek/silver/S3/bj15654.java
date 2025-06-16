package baek.silver.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj15654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] nums;
    static boolean[] visited;
    static StringBuilder sb;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        BTC(0, 0);
    }

    static void BTC(int start, int level) {
        if (level == M) {
            sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }
            System.out.println(sb);
        }
        for (int i = 0; i < N; i++) {

            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                BTC(i + 1, level + 1);
                list.remove(list.size()-1);
                visited[i] = false;
            }

        }
    }
}
