package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1904 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr = new int[1000001];
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= 1000000; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
        }
        System.out.println(arr[N]);
    }

}