package baek.step.deep2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class bj25192 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int count = N;
        while (N-- > 0) {
            String line = br.readLine();
            if (line.equals("ENTER")) {
                set = new HashSet<>();
                count--;
                continue;
            }
            if (set.contains(line)) {
                count--;
            }
            set.add(line);
        }
        System.out.println(count);
    }
}