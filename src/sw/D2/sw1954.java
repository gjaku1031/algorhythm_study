package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1954 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int case_num = 1; case_num <= T; case_num++) {

            int N = Integer.parseInt(br.readLine());
            count = N;
            int[][] nums = new int[N][N];

            int x = 0;
            int y = 0;

            snail(nums, x, y, N);


        }

    }

    static void snail(int[][] nums, int x, int y, int N) {
        if (x==0 && y==0) {
            for (int i = 1; i <= N; i++) {
                nums[x][i] = i;
            }
        }


    }
}
