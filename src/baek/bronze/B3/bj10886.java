package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cuteCount = 0;

        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(br.readLine()) == 1) {
                cuteCount++;
            }
        }

        if (cuteCount > n / 2) {
            System.out.println("Junhee is cute!");
        } else {
            System.out.println("Junhee is not cute!");
        }
    }
}
