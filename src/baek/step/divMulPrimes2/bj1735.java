package baek.step.divMulPrimes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1735 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int x1, x2, y1, y2;

    public static void main(String[] args) throws IOException {
        // 입력받기
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());


        // 약분하기
        int temp1 = Euclidean(x1, y1);
        int temp2 = Euclidean(x2, y2);

        x1 /= temp1;
        x2 /= temp2;
        y1 /= temp1;
        y2 /= temp2;

        temp1 = Euclidean(x1, y2);
        temp2 = Euclidean(x2, y1);

        x1 /= temp1;
        y2 /= temp1;
        x2 /= temp2;
        y1 /= temp2;

        System.out.println((x1 * y2 + x2 * y1) + " " + (y1 * y2));
    }

    static int Euclidean(int a, int b) {
        if (b == 0)
            return a;
        return Euclidean(b, a % b);
    }
}
