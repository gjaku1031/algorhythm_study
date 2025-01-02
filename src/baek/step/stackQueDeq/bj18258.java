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
    }

    public static class QueEx {
        int prev;
        Queue<Integer> queInt = new LinkedList<>();

        public void pushQue(int a) {
            queInt.offer(a);
            prev = a;
        }

        public void popQue() {
            if (!queInt.isEmpty()) {
                System.out.println(queInt.poll());
            } else {
                System.out.println(-1);
            }
        }

        public void sizeQue() {
            System.out.println(queInt.size());
        }

        public void isQueEmpty() {
            if (queInt.isEmpty()) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        public void frontQue() {
            if (!queInt.isEmpty()) {
                System.out.println(queInt.peek());
            } else {
                System.out.println(-1);
            }
        }

        public void backQue() {
            if (!queInt.isEmpty()) {
                System.out.println(prev);
            } else {
                System.out.println(-1);
            }
        }
    }
}

