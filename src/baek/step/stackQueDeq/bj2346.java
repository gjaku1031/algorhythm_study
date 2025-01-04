package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] target = new int[N];
        Balloon balloon = new Balloon(N, target);
        balloon.setBalloons();
        balloon.explodeBalloon();
    }

    static class Balloon {
        int N;
        Deque<Integer> balloons = new ArrayDeque<>();
        int[] target;
        int nextTarget;
        StringBuilder sb = new StringBuilder();

        public Balloon(int n, int[] target) {
            N = n;
            this.target = target;
        }

        public void setBalloons() {
            for (int i = 1; i <= N; i++) {
                balloons.addLast(i);
            }
        }

        public void explodeBalloon() {
            // 첫 타겟은 첫 번째 풍선의 쪽지
            nextTarget = target[0];
            balloons.pollFirst();

            System.out.println(sb);
        }
    }
}
