package baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int a = Integer.parseInt(str.substring(0, 1));
            int b = Integer.parseInt(str.substring(2, 3));
            System.out.println(a + b);
        }
    }
}
