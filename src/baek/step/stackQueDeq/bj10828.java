package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StackEx stackEx = new StackEx();


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push")) {
                int n = Integer.parseInt(st.nextToken());
                stackEx.pushStack(n);
            } else if (s.equals("top")) {
                stackEx.peekStack();
            } else if (s.equals("size")) {
                stackEx.sizeStack();
            } else if (s.equals("empty")) {
                stackEx.isStackEmpty();
            } else if (s.equals("pop")) {
                stackEx.popStack();
            }
        }
    }

    public static class StackEx {
        Stack<Integer> stackInt = new Stack<>();

        public void pushStack(int a) {
            stackInt.push(a);
        }

        public void peekStack() {
            if (!stackInt.isEmpty()) {
                System.out.println(stackInt.peek());

            } else {
                System.out.println(-1);
            }
        }

        public void sizeStack() {
            System.out.println(stackInt.size());
        }

        public void isStackEmpty() {
            if (stackInt.isEmpty()) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        public void popStack() {
            if (!stackInt.isEmpty()) {
                System.out.println(stackInt.pop());
            } else {
                System.out.println(-1);
            }
        }
    }



}

