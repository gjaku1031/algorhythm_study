package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1215 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[][] pal;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= 10; tc++) {

            //입력
            pal = new char[8][8];
            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                for (int j = 0; j < 8; j++) {
                    pal[i][j] = str.charAt(i);
                }
            }

            int result = 0;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                }
            }







        }
    }

    static void solve() {

    }

    static boolean isPal(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < 8 && c >= 0 && c < 8;
    }
}
