package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2166 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        long sum = 0L;
        for (int i = 0; i < N; i++) {
            int j = (i + 1) % N;
            sum += (long) arr[i][0] * arr[j][1] - (long) arr[i][1] * arr[j][0];
        }
        double area = Math.abs(sum) / 2.0;
        System.out.printf("%.1f%n", area);
    }
}