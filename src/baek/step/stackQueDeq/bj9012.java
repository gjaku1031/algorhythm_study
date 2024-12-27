package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class bj9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stackInt = new Stack<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            checkStack(s, stackInt);
        }

    }

    static void checkStack(String s, Stack<Integer> stackInt) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stackInt.push(1);
            } else if (s.charAt(i) == ')' && stackInt.isEmpty()) {
                System.out.println("NO");
                return;
            } else if (s.charAt(i) == ')' && !stackInt.isEmpty()) {
                stackInt.pop();
            }
        }
        if (stackInt.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
