package baek.bronze.B5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class bj10757 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BigInteger A, B;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = new BigInteger(st.nextToken());
        B = new BigInteger(st.nextToken());
        System.out.println(A.add(B));
    }
}
