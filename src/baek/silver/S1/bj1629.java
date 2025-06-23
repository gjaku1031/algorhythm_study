package baek.silver.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1629 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long A, B, C;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(recur(A, B));
    }

    static long recur(long D, long B) {
        if (B == 1) {
            return D % C;
        }
        long temp = recur(D, B / 2);
        long result = (temp * temp) % C;

        if (B % 2 == 1) {
            result = (result * D) % C;
        }
        return result;
    }
}
