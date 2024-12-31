package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            if (line.equals(".")) {
                break;
            }
            checkStack(line);
        }
    }

    static void checkStack(String line) {
        Stack<Character> stackCh = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                stackCh.push('(');
            } else if (line.charAt(i) == '[') {
                stackCh.push('[');
            } else if (line.charAt(i) == ')') {
                if (!stackCh.isEmpty() && stackCh.peek() == '(') {
                    stackCh.pop();
                } else {
                    System.out.println("no");
                    return;
                }
            } else if (line.charAt(i) == ']') {
                if (!stackCh.isEmpty() && stackCh.peek() == '[') {
                    stackCh.pop();
                } else {
                    System.out.println("no");
                    return;
                }
            }
        }
        if (stackCh.isEmpty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}