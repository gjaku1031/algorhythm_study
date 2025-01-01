package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Josephus josephus = new Josephus(N, K);
        josephus.jose();
        josephus.joseResult();
    }

    static class Josephus {
        int N;
        int K;

        public Josephus(int n, int k) {
            N = n;
            K = k;
        }

        int div;
        Queue<Integer> que = new LinkedList<>();
        StringBuilder result = new StringBuilder("<");

        void setQue() {
            for (int i = 1; i <= N; i++) {
                que.add(i);
            }
        }

        void setNewN() {
            if (que.size() != div) {
                div = K % que.size();
            }
        }

        void jose() {
            setQue();
            while (!que.isEmpty()) {
                setNewN();
                Queue<Integer> preQue = que;
                Queue<Integer> lateQue = new LinkedList<>();

                // K-1번째 사람까지 pass
                for (int i = 0; i < div - 1; i++) {
                    System.out.println(preQue.peek()+"번 사람 이동");
                    lateQue.add(preQue.poll());
                }
                // K번째 사람 제거
                System.out.println(preQue.peek()+"번 사람 삭제");
                result.append(preQue.poll()).append(", ");
                // 나머지 인원 제거
                while (!lateQue.isEmpty()) {
                    System.out.println(preQue.peek()+"번 사람 이동");
                    preQue.add(lateQue.poll());
                }
                que = preQue;
            }
        }

        void joseResult() {
            result.delete(result.length() - 2, result.length());
            result.append(">");
            System.out.println(result);
        }
    }
}
