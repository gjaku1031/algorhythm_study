package baek.bronze.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj20001 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        br.readLine();
        while (true) {
            String now = br.readLine();
            if (now.equals("고무오리 디버깅 끝")) {
                break;
            } else if (now.equals("문제")) {
                stack.add("문제");
            }else if (stack.isEmpty() && now.equals("고무오리")) {
                stack.add("문제");
                stack.add("문제");
            } else if (now.equals("고무오리")) {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            System.out.println("고무오리야 사랑해");
        } else {
            System.out.println("힝구");
        }
    }
}
