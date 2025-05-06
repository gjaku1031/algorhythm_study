package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw21425 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int count = 0;
            while (true) {
                if (Math.max(A, B) == A && A <= N) {
                    B += A;
                    count++;
                } else if (Math.max(A, B) == B && B <= N) {
                    A += B;
                    count++;
                } else {
                    System.out.println(count);
                    break;
                }

            }
        }
    }
}
