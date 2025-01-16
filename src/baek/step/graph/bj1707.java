package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj1707 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Node>[] graph;
    static StringTokenizer st;
    static int K, V, E;
    static Deque<Node> deque = new ArrayDeque<>();
    static boolean[] visited;
    static Node[] nodes;


    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            visited = new boolean[V + 1];

            // 모든 노드 흰색으로 색칠
            nodes = new Node[V + 1];
            for (int j = 0; j <= V; j++) {
                nodes[j] = new Node(j, Color.White);
            }

            // 노드 연결 시작
            graph = new ArrayList[V + 1];
            for (int j = 0; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(nodes[b]);
                graph[b].add(nodes[a]);
            }

            //BFS 세팅
            visited[1] = true;
            nodes[1].setColor(Color.Red);
            deque.add(nodes[1]);
            BFS();
        }
    }

    static class Node {
        int index;
        Color color;

        public Node(int index, Color color) {
            this.index = index;
            this.color = color;
        }

        public int getIndex() {
            return index;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

    enum Color {
        White,
        Blue,
        Red,
        ;
    }

    static void BFS() {
        while (!deque.isEmpty()) {
            Node now = deque.pollFirst();
            int nowIdx = now.getIndex();
            for (int i = 0; i < graph[nowIdx].size(); i++) {
                Node next = graph[nowIdx].get(i);
                int nextIdx = next.getIndex();
                if (!visited[nextIdx]) {
                    visited[nextIdx] = true;
                    deque.addLast(next);
                    if (now.getColor() == Color.Blue) {
                        if (next.getColor() == Color.White) {
                            next.setColor(Color.Red);
                        } else {
                            System.out.println("NO");
                            return;
                        }
                    }
                    if (now.getColor() == Color.Red) {
                        if (next.getColor() == Color.White) {
                            next.setColor(Color.Blue);
                        } else {
                            System.out.println("NO");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("YES");
    }
}