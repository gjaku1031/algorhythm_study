package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] computers;
    static StringTokenizer st ;
    static boolean[] visited;
    static int N, M;
    static int count = -1;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        computers = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers[a].add(b);
            computers[b].add(a);
        }
        visited[1] = true;
        BFS(1);
        System.out.println(count);
    }

    static void BFS(int now) {
        count++;
        for (int i = 0; i < computers[now].size(); i++) {
            int next = computers[now].get(i);
            if (!visited[next]) {
                visited[next] = true;
                BFS(next);
            }
        }
    }
}
