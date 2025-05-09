package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1289 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String memory = br.readLine();
            System.out.println("#" + tc + " " + recovery(memory));
        }
    }

    static int recovery(String memory) {

        char current = memory.charAt(0);
        int count = current == '0' ? 0 : 1;

        for (int i = 1; i < memory.length(); i++) {
            if (memory.charAt(i) != current) {
                current = memory.charAt(i);
                count++;
            }
        }
        return count;
    }
}
