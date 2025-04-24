package sw.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2071 {
    static int T;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for (int count = 1; count <= T; count++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            System.out.println("#" + count + " " + Math.round((double) sum / 10));

        }
    }
}
