package baek.step.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());
            remain(money);
        }
    }

    static void remain(int money) {
        int[] changes = new int[4];
        changes[0] = money / 25;
        money = money % 25;

        changes[1] = money / 10;
        money = money % 10;

        changes[2] = money / 5;
        money = money % 5;

        changes[3] = money;
        for (int change : changes) {
            System.out.print(change + " ");
        }
        System.out.println();
    }
}
