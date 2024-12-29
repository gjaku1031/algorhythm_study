package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stackInt1 = new Stack<>();
        Stack<Integer> stackInt2 = new Stack<>();

        while (true) {
            if (true) {
            }
        }
    }

    static void checkStack(String s, Stack<Integer> stackInt1, Stack<Integer> stackInt2) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stackInt1.push(1);
            } else if (s.charAt(i) == ')' && stackInt1.isEmpty()) {
                System.out.println("no");
                return;
            } else if (s.charAt(i) == ')' && !stackInt1.isEmpty()) {
                stackInt1.pop();
            } else if (s.charAt(i)=='[') {
                stackInt2.push(1);
            } else if (s.charAt(i) == ']' && stackInt1.isEmpty()) {
                System.out.println("no");
            } else if (s.charAt(i) == ']' && !stackInt1.isEmpty()) {
                stackInt2.pop();
            }
        }
        if (stackInt1.isEmpty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
