package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj30468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long STR = Long.parseLong(st.nextToken());
        long DEX = Long.parseLong(st.nextToken());
        long INT = Long.parseLong(st.nextToken());
        long LUK = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        long sum = STR + DEX + INT + LUK;
        long required = 4L * N;
        long answer = Math.max(0L, required - sum);

        System.out.println(answer);
    }
}
