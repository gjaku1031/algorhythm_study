package sw.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1824 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int C, R;
    static char[][] arr;

    // 우 하 좌 상
    static int[] dc = {1, 0, -1, 0};
    static int[] dr = {0, 1, 0, -1};
    static int idx;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            arr = new char[C][R];

            for (int i = 0; i < C; i++) {
                String str = br.readLine();
                for (int j = 0; j < R; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            idx = 0;
        }
    }
}