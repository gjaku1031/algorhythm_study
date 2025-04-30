package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1288 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            boolean[] check = new boolean[10];
            int num = 0;

            while (true) {
                num += N;
                int temp = num;
                while (temp > 0) {
                    check[temp % 10] = true;
                    temp /= 10;
                }
                boolean allChecked = true;
                for (int i = 0; i < 10; i++) {
                    if (!check[i]) {
                        allChecked = false;
                        break;
                    }
                }
                if (allChecked) {
                    break;
                }
            }
            System.out.println("#" + tc + " " + num);
        }
    }
}