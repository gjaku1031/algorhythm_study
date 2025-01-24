package baek.step.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

// 같이 코드 작성 가능


public class bj14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> deq = new ArrayDeque<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static StringTokenizer st;
    static int[][] lapMap;
    static boolean[][] visited;
    static ArrayList<Node> nodes = new ArrayList<>();
    static int N, M;
    static int max;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lapMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                lapMap[i][j] = a;
                if (a == 2) {
                    nodes.add(new Node(i, j));
                    //System.out.println("노드 추가됨");
                }
            }
        }

        BTC(0, 0, 0);
        System.out.println(max);
    }

    static void BTC(int startRow, int startCol, int depth) {
        if (depth == 3) { // 벽 다세웠으면 BFS
            int[][] copy = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                System.arraycopy(lapMap[i], 0, copy[i], 0, M);
            }
            for (Node node : nodes) {
                deq.add(node);
                BFS(copy);
            }

            deq.clear();

            //안전지대 확인
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copy[i][j] == 0) {
                        count++;
                    }
                }
            }
            max = Math.max(max, count);
            return;
        }

        //BTC 로직
        for (int i = startRow; i < N; i++) {
            for (int j = (i == startRow ? startCol : 0); j < M; j++) {
                if (lapMap[i][j] == 0) {
                    lapMap[i][j] = 1;
                    BTC(i, j + 1, depth + 1);
                    lapMap[i][j] = 0;
                }
            }
        }
    }

    static void BFS(int[][] copy) {
        while (!deq.isEmpty()) {
            Node now = deq.pollFirst();
            int currentRow = now.getRow();
            int currentCol = now.getCol();
            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + dx[i];
                int nextCol = currentCol + dy[i];

                if (!valid(nextRow,nextCol)) {
                    continue;
                }

                if (visited[nextRow][nextCol]) {
                    continue;
                }

                if (copy[nextRow][nextCol] == 0) {
                    visited[nextRow][nextCol] = true;
                    copy[nextRow][nextCol] = 2;
                    deq.addLast(new Node(nextRow, nextCol));
                }
            }
        }
    }

    static boolean valid(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}
//