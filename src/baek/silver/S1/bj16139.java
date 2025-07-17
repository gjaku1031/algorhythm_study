package baek.silver.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16139 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String S;
    static int q;
    static char a;
    static int l, r;

    public static void main(String[] args) throws IOException {
        S = br.readLine();
        q = Integer.parseInt(br.readLine());
        int[][] sum = new int[26][S.length()];
        for (int i = 0; i < 26; i++) {
            char current_char = (char) (i + 'a');
            if (S.charAt(0) == current_char) {
                sum[i][0] = 1;
            } else {
                sum[i][0] = 0;
            }
            for (int j = 1; j < S.length(); j++) {
                if (S.charAt(j) == current_char) {
                    sum[i][j] = sum[i][j - 1] + 1;
                } else {
                    sum[i][j] = sum[i][j - 1];
                }
            }
        }

        for (int tc = 0; tc < q; tc++) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken().charAt(0);

            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            int current_idx = a-'a';
            if (l==0) {
                sb.append(sum[current_idx][r]).append("\n");
            }else{
                sb.append(sum[current_idx][r]-sum[current_idx][l-1]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
