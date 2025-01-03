package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DequeEx dequeEx = new DequeEx();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push_front")) {
                int n = Integer.parseInt(st.nextToken());
                dequeEx.push_front(n);
            } else if (s.equals("push_back")) {
                int n = Integer.parseInt(st.nextToken());
                dequeEx.push_back(n);
            } else if (s.equals("pop_front")) {
                dequeEx.pop_front();
            } else if (s.equals("pop_back")) {
                dequeEx.pop_back();
            } else if (s.equals("size")) {
                dequeEx.deqSize();
            } else if (s.equals("empty")) {
                dequeEx.deqEmpty();
            } else if (s.equals("front")) {
                dequeEx.deqFront();
            } else if (s.equals("back")) {
                dequeEx.deqBack();
            }
        }
        dequeEx.result();
    }





    static class DequeEx {
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        public void push_front(int X) {
            deque.addFirst(X);
        }

        public void push_back(int X) {
            deque.addLast(X);
        }

        public void pop_front() {
            if (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
            } else {
                sb.append(-1);
            }
            sb.append("\n");
        }

        public void pop_back() {
            if (!deque.isEmpty()) {
                sb.append(deque.pollLast());
            } else {
                sb.append(-1);
            }
            sb.append("\n");
        }

        public void deqSize() {
            sb.append(deque.size());
            sb.append("\n");
        }

        public void deqEmpty() {
            if (deque.isEmpty()) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }

        public void deqFront() {
            if (deque.isEmpty()) {
                sb.append(-1);
            } else {
                sb.append(deque.getFirst());
            }
            sb.append("\n");
        }

        public void deqBack() {
            if (deque.isEmpty()) {
                sb.append(-1);
            } else {
                sb.append(deque.getLast());
            }
            sb.append("\n");
        }

        public void result() {
            System.out.println(sb);
        }

    }
}
