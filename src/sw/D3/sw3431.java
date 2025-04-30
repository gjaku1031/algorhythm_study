package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw3431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            if (X <= L) {
                System.out.println("#" + tc + " " + (L - X));
            } else if (X <= U) {
                System.out.println("#" + tc + " " + 0);
            } else {
                System.out.println("#" + tc + " " + -1);
            }

        }
    }
}
