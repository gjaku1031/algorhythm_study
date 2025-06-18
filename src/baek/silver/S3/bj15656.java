package baek.silver.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj15656 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] nums;
    static StringBuilder sb1;
    static StringBuilder sb2 = new StringBuilder();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        BTC(0, 0);
        System.out.println(sb2);
    }

    static void BTC(int start, int level) {
        if (level == M) {
            sb1 = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb1.append(list.get(i)).append(" ");
            }
            sb2.append(sb1.toString()).append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {

            list.add(nums[i]);
            BTC(i + 1, level + 1);
            list.remove(list.size() - 1);
        }
    }
}