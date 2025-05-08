package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited = new boolean[100001];
    static Deque<Node> deq = new ArrayDeque<>();
    static StringTokenizer st;
    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        Node node = new Node(N, 0);
        deq.addLast(node);
        visited[node.getLocation()] = true;
        BFS();
    }

    static class Node {
        int location;
        int level;

        public int getLocation() {
            return location;
        }

        public int getLevel() {
            return level;
        }

        public Node(int location, int level) {
            this.location = location;
            this.level = level;
        }
    }

    static void setDeq(Node now) {
        int nowLevel = now.getLevel();
        int front = now.getLocation() + 1;
        int back = now.getLocation() - 1;
        int teleport = now.getLocation() * 2;

        if (front <= 100000 && !visited[front]) {
            deq.add(new Node(front, nowLevel + 1));
            visited[front] = true;
        }
        if (back >= 0 && back <= 100000 && !visited[back]) {
            deq.add(new Node(back, nowLevel + 1));
            visited[back] = true;
        }
        if (teleport <= 100000 && !visited[teleport]) {
            deq.add(new Node(teleport, nowLevel + 1));
            visited[teleport] = true;
        }
    }

    static void BFS() {
        while (!deq.isEmpty()) {
            Node now = deq.pollFirst();
            if (now.getLocation() == K) {
                System.out.println(now.getLevel());
                return;
            }
            setDeq(now);
        }
    }
}
