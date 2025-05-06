package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1946 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                char ch = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                for (int j = 0; j < num; j++) {
                    sb.append(ch);
                }
            }
            String str = sb.toString();
            System.out.println("#" + tc);
            for (int i = 0; i <= str.length() / 10; i++) {
                if (i == str.length() / 10) {
                    System.out.println(str.substring(i * 10));
                } else {
                    System.out.println(str.substring(i * 10, i * 10 + 10));
                }
            }
        }
    }
}
