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
            count = 2
            ;
            int[][] nums = new int[N][N];
            nums[0][0] = 1;


            int x = 0;
            int y = 0;




        }

    }

    //좌상단에서 우향
    static void snail_1(int[][] nums, int x, int y, int N) {
        int now = y + 1;

        for (int i = 1; i < N; i++) {
            if (nums[x][y + i] != 0) {
                now = y + i;
                nums[x][now] = count++;
            } else if (count == N + 1) {
                return;
            } else {
                snail_2(nums, x, now + 1, N);
                return;
            }
        }
    }
    //우상단에서 하향
    static void snail_2(int[][] nums, int x, int y, int N){
        int now = x + 1;

        for (int i = 1; i < N; i++) {
            if (nums[x + i][y] != 0) {
                now = x + i;
                nums[now][y] = count++;
            } else if (count == N + 1) {
                return;
            } else {
                snail_3(nums, now + 1, y, N);
                return;
            }
        }
    }

    //우하단에서 좌향
    static void snail_3(int[][] nums, int x, int y, int N) {
        int now = y - 1;
        for (int i = 1; i < N; i++) {
            if (nums[x][y - i] != 0) {
                now = y - i;
                nums[x][now] = count++;
            } else if (count == N + 1) {
                return;
            } else {
                snail_2(nums, x, now + 1, N);
                return;
            }
        }
    }

    //좌하단에서 상향
}
