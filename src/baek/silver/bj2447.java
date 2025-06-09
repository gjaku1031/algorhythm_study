package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2447 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] result;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        result = new char[N][N];
        function(0, 0, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (result[i][j] == 0) {
                    sb.append(" ");
                } else {
                    sb.append('*');
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    static void function(int start_r, int start_c, int length) {
        if (length == 3) {
            for (int i = start_r; i < start_r + 3; i++) {
                for (int j = start_c; j < start_c + 3; j++) {
                    if (i == start_r + 1 && j == start_c + 1) {
                        continue;
                    }
                    result[i][j] = '*';
                }
            }
            return;
        }
        int div = length / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 || j != 1) {
                    function(start_r + div * i, start_c + div * j, div);
                }
            }
        }

    }
}
