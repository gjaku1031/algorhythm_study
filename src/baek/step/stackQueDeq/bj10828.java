package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
                stackEx.pushQue(n);
            } else if (s.equals("front")) {
                stackEx.frontQue();
            } else if (s.equals("size")) {
                stackEx.sizeQue();
            } else if (s.equals("empty")) {
                stackEx.isQueEmpty();
            } else if (s.equals("pop")) {
                stackEx.popQue();
            } else if (s.equals("back")) {
                stackEx.backQue();
            }
        }
    }

    public static class StackEx {
        int prev;
        Queue<Integer> queInt = new LinkedList<>();
        public void pushQue(int a) {
            queInt.offer(a);
            prev = a;
        }

        public void backQue() {
            if (!queInt.isEmpty()) {
                System.out.println(prev);
            } else {
                System.out.println(-1);
            }
        }

        public void frontQue() {
            if (!queInt.isEmpty()) {
                System.out.println(queInt.peek());
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

        public void popQue() {
            if (!queInt.isEmpty()) {
                System.out.println(queInt.remove());
            } else {
                System.out.println(-1);
            }
        }
    }
}

