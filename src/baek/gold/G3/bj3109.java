package baek.gold.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3109 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 우상, 우, 우하
    static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};

    static int R, C;
    static char[][] map;

    static int result = 0;


    public static void main(String[] args) throws IOException {
        // 입력
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        
        for (int i = 0; i < R; i++) {
            bread(i, 1);
        }



    }

    static void bread(int idx, int c) {
        if (c == C) {
            result++;
            return;
        }

        for (int i = 0; i < C; i++) {

        }
        
    }

    static boolean valid(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}