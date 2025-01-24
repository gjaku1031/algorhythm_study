package baek.step.divMulPrimes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13241 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long a, b;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        long gcm = Euclidean(a, b);
        System.out.println(LCM(gcm));
    }

    static long Euclidean(long a, long b) {
        if (b == 0)
            return a;
        return Euclidean(b, a % b);
    }


    static long LCM(long gcm) {
        long x = a / gcm;
        long y = b / gcm;
        return gcm * x * y;
    }
}

