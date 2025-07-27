package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1753 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V, E, K;
    static int[] distance;

    static List<Node>[] graph;
    static PriorityQueue<Node> que = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        // 입력
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, weight));
        }

        // 각각의 노드로의 거리 무한대로 초기화
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 시작점에서 시작점의 거리는 0
        que.offer(new Node(K, 0));
        distance[K] = 0;

        // 다익스트라 알고리즘 시작
        while (!que.isEmpty()) {
            Node current_node = que.poll();

            if (distance[current_node.idx] < current_node.cost) continue;

            for (int i = 0; i < graph[current_node.idx].size(); i++) {
                Node next_node = graph[current_node.idx].get(i);
                if (distance[next_node.idx] > current_node.cost + next_node.cost) {
                    distance[next_node.idx] = current_node.cost + next_node.cost;
                    que.offer(new Node(next_node.idx, distance[next_node.idx]));
                }
            }
        }

        // 출력
        for (int i = 1; i <= V; i++) {
            System.out.println(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
        }
    }

    static class Node implements Comparable<Node> {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}