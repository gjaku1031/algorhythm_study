package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Snack snack = new Snack(arr);
        snack.line();
        snack.checkStack();
        snack.result();
    }

    static class Snack {
        int[] arr;
        int currentIndex = 0;
        Stack<Integer> stack = new Stack<>();

        public Snack(int[] arr) {
            this.arr = arr;
        }

        public void line() {
            for (int i = 0; i < arr.length; i++) {
                if (currentIndex + 1 == arr[i]) {
                    currentIndex++;
                    System.out.println(arr[i] + "번 간식받음");
                } else if (!stack.isEmpty() && stack.peek() == currentIndex + 1) {
                    checkStack();
                    i--;
                } else {
                    stack.push(arr[i]);
                    System.out.println(arr[i] + "번 줄섬");
                    System.out.println("현재줄" + stack);
                }
            }
        }

        public void checkStack() {
            while (!stack.isEmpty() && currentIndex + 1 == stack.peek()) {
                System.out.println(stack.peek() + "번 간식 이제야 받으러 감");
                stack.pop();
                currentIndex++;
            }
        }

        public void result() {
            if (stack.isEmpty()) {
                System.out.println("Nice");
            } else {
                System.out.println("Sad");
            }
        }
    }
}

