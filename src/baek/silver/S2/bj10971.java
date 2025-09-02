package baek.silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10971 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] W;
    static int sum;
    static boolean[] visited; 
    static int sr, sc;        

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        W = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            sr = i;
            sc = i;
            visited = new boolean[N];
            visited[sr] = true;
            sum = 0;
            bt(sr, sr, 1);
        }

        System.out.println(result);
    }

    
    static void bt(int r, int c, int lv) {
        if (sum >= result) return;

        if (lv == N) {
            if (W[r][sr] != 0) {
                result = Math.min(result, sum + W[r][sr]);
            }
            return;
        }

        for (int next = 0; next < N; next++) {
            if (!visited[next] && W[r][next] != 0) {
                visited[next] = true;
                sum += W[r][next];
                bt(next, c, lv + 1);
                sum -= W[r][next];
                visited[next] = false;
            }
        }
    }
}
