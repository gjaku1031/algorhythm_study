package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StackEx stackEx = new StackEx();


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            if (s == 1) {
                int n = Integer.parseInt(st.nextToken());
                stackEx.pushStack(n);
            } else if (s == 5) {
                stackEx.peekStack();
            } else if (s == 3) {
                stackEx.sizeStack();
            } else if (s == 4) {
                stackEx.isStackEmpty();
            } else if (s == 2) {
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

