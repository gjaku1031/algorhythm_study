package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxPassengers = 0;
        int currentPassengers = 0;

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int off = Integer.parseInt(st.nextToken());
            int on = Integer.parseInt(st.nextToken());

            currentPassengers = currentPassengers - off + on;

            if (currentPassengers > maxPassengers) {
                maxPassengers = currentPassengers;
            }
        }

        System.out.println(maxPassengers);
    }
}
