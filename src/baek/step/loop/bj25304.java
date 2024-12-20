package baek.step.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj25304 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalPrice = Integer.parseInt(br.readLine());
        int itemCount = Integer.parseInt(br.readLine());

        Receipt receipt = new Receipt(totalPrice, itemCount);

        int sum = 0;
        for (int i = 0; i < receipt.itemCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int itemPrice = Integer.parseInt(st.nextToken());
            int itemQuantity = Integer.parseInt(st.nextToken());
            sum += itemPrice * itemQuantity;
        }
        System.out.println(receipt.checkCal(sum));

    }

    static class Receipt {
        int totalPrice;
        int itemCount;

        Receipt(int totalPrice, int itemCount) {
            this.totalPrice = totalPrice;
            this.itemCount = itemCount;
        }

        String checkCal(int sum) {
            return (sum == totalPrice) ? "Yes" : "No";
        }
    }
}
