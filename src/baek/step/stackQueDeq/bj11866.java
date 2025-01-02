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
            this.N = n;
            this.K = k;
        }

        int div;
        Queue<Integer> que = new LinkedList<>();
        StringBuilder result = new StringBuilder("<");

        void setQue() {
            for (int i = 1; i <= N; i++) {
                que.add(i);
            }
        }

        void setNewDiv() {
            if (K % que.size() != 0) {
                div = K % que.size();
            } else {
                div = que.size();
            }
        }

        void jose() {
            //que 에 사람 저장
            setQue();
            int k = 1;
            while (!que.isEmpty()) {
                //System.out.println("현재 K는 " + K + " 현재 que.size 는 " + que.size());
                //System.out.println("시작 전 que 는 " + que);
                setNewDiv();
                //System.out.println(k + "차 jose 시작 현재 div 는 " + div);
                // 나눌 수 set

                Queue<Integer> preQue = que;
                Queue<Integer> lateQue = new LinkedList<>();

                // K-1번째 사람까지 pass
                for (int i = 0; i < div - 1; i++) {
                    //System.out.println(preQue.peek()+"번 사람 이동");
                    lateQue.add(preQue.poll());
                }
                // K번째 사람 제거
                //System.out.println(preQue.peek()+"번 사람 삭제");
                result.append(preQue.poll()).append(", ");
                // 나머지 인원 제거
                while (!lateQue.isEmpty()) {
                    //System.out.println(preQue.peek()+"번 사람 이동");
                    preQue.add(lateQue.poll());
                }
                que = preQue;
                //System.out.println(k + "차 jose 끝 현재 que 는 " + que);
                //System.out.println(k + "차 jose 끝 jose 는 " + result);
                //System.out.println("--------------------------------------");
                k++;
            }
        }

        void joseResult() {
            result.delete(result.length() - 2, result.length());
            result.append(">");
            System.out.println(result);
        }
    }
}
