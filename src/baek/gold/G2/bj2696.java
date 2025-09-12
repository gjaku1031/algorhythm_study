package baek.gold.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj2696 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, M;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            M = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            List<Integer> medians = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                if (i % 10 == 0)
                    st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                if (maxHeap.size() == minHeap.size()) maxHeap.add(num);
                else minHeap.add(num);


                // 두 힙의 균형 맞추기 (maxHeap의 top은 항상 minHeap의 top보다 작거나 같아야 함)
                if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                    int val1 = maxHeap.poll();
                    int val2 = minHeap.poll();
                    maxHeap.add(val2);
                    minHeap.add(val1);
                }

                // 전체 원소 개수가 홀수 -> 중앙값 리스트에 추가
                if ((i + 1) % 2 != 0) medians.add(maxHeap.peek());

            }

            sb.append(medians.size()).append("\n");
            for (int i = 0; i < medians.size(); i++) {
                sb.append(medians.get(i));
                if ((i + 1) % 10 == 0 || i == medians.size() - 1) sb.append("\n");
                else sb.append(" ");
            }
        }
        System.out.print(sb);
    }
}