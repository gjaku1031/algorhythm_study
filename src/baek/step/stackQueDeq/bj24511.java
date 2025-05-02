package baek.step.stackQueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj24511 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int[] queOrStack = new int[N];
        // 2번째 줄 -> que -> 0, stack -> 1
        for (int i = 0; i < N; i++) {
            queOrStack[i] = Integer.parseInt(st1.nextToken());
        }

        // 초기값
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st2.nextToken());
            if (queOrStack[i] == 0) {
                deque.addLast(a);
            }
        }

        int M = Integer.parseInt(br.readLine());

        // 넣을 값
        int[] inputNum = new int[M];
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            inputNum[i] = Integer.parseInt(st3.nextToken());
        }



        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            deque.addFirst(inputNum[i]);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}
