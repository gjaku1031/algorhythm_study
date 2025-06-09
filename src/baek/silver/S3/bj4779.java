package baek.silver.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj4779 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] line;

    public static void main(String[] args) throws IOException {
        String input;
        StringBuilder sb = new StringBuilder();

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int N = Integer.parseInt(input);
            line = new int[(int) Math.pow(3, N)];
            Arrays.fill(line, 1);
            function(0, line.length);

            for (int i = 0; i < line.length; i++) {
                if (line[i] == 1) {
                    sb.append('-');
                } else {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void function(int start, int length) {
        if (length == 1) {
            return;
        }
        int now_length = length / 3;
        for (int i = start + now_length; i < start + now_length * 2; i++) {
            line[i] = 0;
        }
        function(start, now_length);
        function(start + 2 * now_length, now_length);
    }
}