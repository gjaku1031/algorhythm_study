package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        QueEx queEx = new QueEx();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push")) {
                int n = Integer.parseInt(st.nextToken());
                queEx.pushQue(n);
            } else if (s.equals("front")) {
                queEx.frontQue();
            } else if (s.equals("size")) {
                queEx.sizeQue();
            } else if (s.equals("empty")) {
                queEx.isQueEmpty();
            } else if (s.equals("pop")) {
                queEx.popQue();
            } else if (s.equals("back")) {
                queEx.backQue();
            }
        }
        queEx.result();
    }

    public static class QueEx {
        int prev;
        Queue<Integer> queInt = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        public void pushQue(int a) {
            queInt.offer(a);
            prev = a;
        }

        public void popQue() {
            if (!queInt.isEmpty()) {
                sb.append(queInt.poll());
            } else {
                sb.append(-1);
            }
            sb.append("\n");
        }

        public void sizeQue() {
            sb.append(queInt.size());
            sb.append("\n");
        }

        public void isQueEmpty() {
            if (queInt.isEmpty()) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }

        public void frontQue() {
            if (!queInt.isEmpty()) {
                sb.append(queInt.peek());
            } else {
                sb.append(-1);
            }
            sb.append("\n");
        }

        public void backQue() {
            if (!queInt.isEmpty()) {
                sb.append(prev);
            } else {
                sb.append(-1);
            }
            sb.append("\n");
        }

        public void result() {
            System.out.println(sb);
        }
    }
}

