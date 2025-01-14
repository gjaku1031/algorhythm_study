package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Coordinate> deq = new ArrayDeque<>();
    static Coordinate[][] maze;
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new Coordinate[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = new Coordinate(i, j);
                maze[i][j].setPath(Integer.parseInt(Character.toString(line.charAt(j))));
            }
        }

        deq.addLast(maze[0][0]);
        maze[0][0].setLevel(1);
        BFS();
        System.out.println(maze[N - 1][M - 1].getLevel());
    }

    static void BFS() {
        while (!deq.isEmpty()) {
            Coordinate now = deq.pollFirst();
            int x = now.getX();
            int y = now.getY();

            //오른쪽
            if (y < M - 1 && !maze[x][y + 1].visited && maze[x][y + 1].path) {
                Coordinate next = maze[x][y + 1];
                next.setVisited(true);
                if (next.getLevel() == 0) {
                    next.setLevel(now.getLevel() + 1);
                } else {
                    next.setLevel(Math.min(next.getLevel(), now.getLevel() + 1));
                }
                deq.addLast(next);
            }

            //아래쪽
            if (x < N - 1 && !maze[x + 1][y].visited && maze[x + 1][y].path) {
                Coordinate next = maze[x + 1][y];
                next.setVisited(true);
                if (next.getLevel() == 0) {
                    next.setLevel(now.getLevel() + 1);
                } else {
                    next.setLevel(Math.min(next.getLevel(), now.getLevel() + 1));
                }
                deq.addLast(next);
            }

            //왼쪽
            if (y > 0 && !maze[x][y - 1].visited && maze[x][y - 1].path) {
                Coordinate next = maze[x][y - 1];
                next.setVisited(true);
                if (next.getLevel() == 0) {
                    next.setLevel(now.getLevel() + 1);
                } else {
                    next.setLevel(Math.min(next.getLevel(), now.getLevel() + 1));
                }

                deq.addLast(next);
            }

            //위쪽
            if (x > 0 && !maze[x - 1][y].visited && maze[x - 1][y].path) {
                Coordinate next = maze[x - 1][y];
                next.setVisited(true);
                if (next.getLevel() == 0) {
                    next.setLevel(now.getLevel() + 1);
                } else {
                    next.setLevel(Math.min(next.getLevel(), now.getLevel() + 1));
                }

                deq.addLast(next);
            }
        }
    }

    static class Coordinate {
        int x, y;
        int level;


        boolean visited = false;
        boolean path = false;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public void setPath(int n) {
            this.path = n == 1;
        }
    }
}