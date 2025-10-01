package baek.gold.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1202 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static PriorityQueue<Jewel> jewelQueue = new PriorityQueue<>();  // 보석을 무게 오름차순으로 관리
    static PriorityQueue<Integer> bag = new PriorityQueue<>();  // 가방을 용량 오름차순으로 관리
    static PriorityQueue<Integer> candidate = new PriorityQueue<>(Collections.reverseOrder());  // 선택 가능한 보석을 가격 내림차순으로 관리

    static class Jewel implements Comparable<Jewel> {
        int weight, price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.weight - o.weight;  // 무게가 가벼운 순서
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력: 보석 개수 N, 가방 개수 K
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // N개의 보석 정보 입력 (무게, 가격)
        // jewelQueue에 자동으로 무게 오름차순 정렬되어 저장됨
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelQueue.add(new Jewel(weight, price));
        }

        // K개의 가방 용량 입력
        // bag에 자동으로 용량 오름차순 정렬되어 저장됨
        for (int i = 0; i < K; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        long answer = 0;  // 최대 가격의 합 (최대 30만 * 100만 = 3000억이므로 long 사용)

        // 각 가방을 용량이 작은 것부터 처리
        for (int i = 0; i < K; i++) {
            int bagCapacity = bag.poll();  // 현재 처리할 가방의 용량

            // 현재 가방에 넣을 수 있는 모든 보석을 candidate에 추가
            // jewelQueue는 무게순이므로, 현재 가방 용량 이하인 모든 보석을 꺼냄
            while (!jewelQueue.isEmpty() && jewelQueue.peek().weight <= bagCapacity) {
                candidate.add(jewelQueue.poll().price);  // 가격만 candidate에 추가 (자동으로 가격 내림차순 정렬)
            }

            // candidate에서 가장 비싼 보석 1개를 선택
            // candidate가 비어있지 않으면 (= 넣을 수 있는 보석이 있으면)
            if (!candidate.isEmpty()) {
                answer += candidate.poll();  // 가장 비싼 보석의 가격을 더함
            }
        }

        System.out.println(answer);
    }
}