package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, R, C;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        solve(0, 0, (int)Math.pow(2, N));
    }

    static void solve(int start_r, int start_c, int len) {
        if (len == 2) {
            if (start_r == R && start_c == C) {
                System.out.println(count);
            } else if (start_r == R && start_c + 1 == C) {
                System.out.println(count+1);
            } else if (start_r + 1 == R && start_c == C) {
                System.out.println(count + 2);
            } else {
                System.out.println(count + 3);
            }
            return;
        }
        if (R < start_r + len / 2 && C < start_c + len / 2) {
            solve(start_r, start_c, len / 2);
        } else if (R < start_r + len / 2 && start_c + len / 2 <= C) {
            count += Math.pow(len / 2, 2);
            solve(start_r, start_c + len / 2, len);
        } else if (start_r + len / 2 <= R && C < start_c + len / 2) {
            count += Math.pow(len / 2, 2) * 2;
            solve(start_r + len / 2, start_c, len / 2);
        } else {
            count += Math.pow(len / 2, 2) * 3;
            solve(start_r + len / 2, start_c + len / 2, len / 2);
        }
    }

}
