package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class bj2460 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int currentPeople = 0;
        int maxPeople = 0;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int getOff = Integer.parseInt(st.nextToken());
            int getOn = Integer.parseInt(st.nextToken());

            currentPeople = currentPeople - getOff + getOn;

            if (maxPeople < currentPeople) {
                maxPeople = currentPeople;
            }
        }
        System.out.println(maxPeople);
    }
}
