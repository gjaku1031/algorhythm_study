package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashSet<Integer> visited = new HashSet<>();
    static Deque<Node> deq = new ArrayDeque<>();
    static StringTokenizer st;
    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Node node = new Node(N, 0);
        deq.addLast(node);
        visited.add(node.getLocation());
        BFS();
    }

    static class Node {
        int location;

        public int getLocation() {
            return location;
        }

        public int getLevel() {
            return level;
        }

        int level;

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

        if (front <= 100000 && !visited.contains(front)) {
            deq.add(new Node(front, nowLevel + 1));
            visited.add(front);
        }
        if (back <= 100000 && !visited.contains(back)) {
            deq.add(new Node(back, nowLevel + 1));
            visited.add(back);
        }
        if (teleport <= 100000 && !visited.contains(teleport)) {
            deq.add(new Node(teleport, nowLevel + 1));
            visited.add(teleport);
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
