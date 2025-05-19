package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw14361 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static char[] line_arr;
    static char[] new_line_arr;
    static String result;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String line = br.readLine();
            line_arr = line.toCharArray();
            Arrays.sort(line_arr);

            int num = Integer.parseInt(line);

            result = "impossible";
            for (int i = 2; true; i++) {
                int now = num * i;
                String new_line = Integer.toString(now);

                if (line.length() != new_line.length()) {
                    break;
                }
                new_line_arr = new_line.toCharArray();
                Arrays.sort(new_line_arr);
                check();
                if (result.equals("possible")) {
                    break;
                }
            }


            System.out.println("#" + tc + " " + result);
        }
    }

    private static void check() {
        for (int i = 0; i < line_arr.length; i++) {
            if (line_arr[i] != new_line_arr[i]) {
                return;
            }
        }
        result = "possible";
    }

}
