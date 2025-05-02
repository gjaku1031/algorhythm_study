package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1940 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int currentSpeed = 0;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int option = Integer.parseInt(st.nextToken());
                if (option == 0) {
                    sum += currentSpeed;
                } else if (option == 1) {
                    int speed = Integer.parseInt(st.nextToken());
                    currentSpeed += speed;
                    sum += currentSpeed;

                } else {
                    int speed = Integer.parseInt(st.nextToken());
                    currentSpeed -= speed;
                    if (currentSpeed < 0) {
                        currentSpeed = 0;
                    }
                    sum += currentSpeed;
                }
            }
            System.out.println("#" + tc + " " + sum);

        }
    }
}
