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
        int currentIndex = 1; // 현재 나가야 하는 번호
        Stack<Integer> stack = new Stack<>();

        // 배열로 줄 생성
        public Snack(int[] arr) {
            this.arr = arr;
        }

        public void line() {
            for (int i = 0; i < arr.length; i++) {
                // 지금 번호랑 (i+1) 번째 번호랑 같으면 나감 -> 지금 번호 +1
                if (currentIndex == arr[i]) {
                    currentIndex++;
                    System.out.println(arr[i] + "번 간식받음");

                // 줄선 맨 앞사람 번호랑 지금 번호가 같음 -> 줄선 맨 앞 사람 나감
                } else if (!stack.isEmpty() && stack.peek() == currentIndex) {
                    checkStack();
                    i--;
                } else {
                    stack.push(arr[i]);
                    System.out.println(arr[i] + "번 줄섬");
                    System.out.println("현재줄" + stack);
                }
            }
        }

        // 줄선 맨 앞사람
        public void checkStack() {
            while (!stack.isEmpty() && currentIndex == stack.peek()) {
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