package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> zeroStack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                zeroStack.pop();
            } else {
                zeroStack.push(a);
            }
            //System.out.println(zeroStack);
        }

        if (!zeroStack.isEmpty()) {
            for (int i = 0; i < zeroStack.size(); i++) {
                //System.out.println("zeroStack.search(i) = " + zeroStack.search(i));
                sum += zeroStack.elementAt(i);
            }
        }
        System.out.println(sum);

    }
}
