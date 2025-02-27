package baek.step.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class bj1654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] arr;
    static int N, M;
    static long max = 0;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
            max = Math.max(max, arr[i]);
        }

        bw.write(binarySearch(1, max) + "\n");
        bw.flush();
        bw.close();
    }

    static long binarySearch(long left, long right) {
        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (satisfy(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    static boolean satisfy(long line) {
        long count = 0;
        for (int i = 0; i < N; i++) {
            count += arr[i] / line;
            if (count >= M) return true;
        }
        return false;
    }
}
