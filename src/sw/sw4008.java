package sw;

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
    static int[] operCount;
    static int[] order;
    static int N;

    static int[] nums;

    static int max;
    static int min;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            N = Integer.parseInt(br.readLine());
            operCount = new int[4];
            order = new int[N - 1];
            nums = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operCount[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            bt(0);
            System.out.println("#" + tc + " " + (max - min));
        }
    }

    static void bt(int level) {
        if (level == N - 1) {
            int temp = nums[0];
            for (int i = 0; i < N - 1; i++) {
                temp = operator(temp, nums[i + 1], order[i]);
            }
            min = Math.min(min, temp);
            max = Math.max(max, temp);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operCount[i] > 0) {
                order[level] = i;
                operCount[i]--;
                bt(level + 1);
                operCount[i]++;
            }
        }
    }

    static int operator(int a, int b, int oper) {
        if (oper == 0) {
            return a + b;
        } else if (oper == 1) {
            return a - b;
        } else if (oper == 2) {
            return a * b;
        } else {
            return a / b;
        }
    }
}