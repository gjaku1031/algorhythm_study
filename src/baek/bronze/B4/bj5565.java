package baek.bronze.B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj5565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalPrice = Integer.parseInt(br.readLine());

        for (int i = 0; i < 9; i++) {
            int bookPrice = Integer.parseInt(br.readLine());
            totalPrice -= bookPrice;
        }

        System.out.println(totalPrice);
    }

}
