package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3034 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        long diag2 = 1L * w * w + 1L * h * h;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(br.readLine().trim());
            if (1L * len * len <= diag2) {
                sb.append("DA");
            } else {
                sb.append("NE");
            }
            if (i + 1 < n) sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
