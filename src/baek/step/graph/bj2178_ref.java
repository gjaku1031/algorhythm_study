package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178_ref {
    // 입력을 읽기 위한 BufferedReader와 StringTokenizer
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 이동 방향을 나타내는 배열 (하, 우, 상, 좌)
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 방문 여부와 최단 경로 길이를 저장하는 배열
    static int[][] visited;

    // 미로를 저장하는 배열
    static int[][] maze;

    // 미로의 크기
    static int N, M;

    public static void main(String[] args) throws IOException {
        // 입력: 첫 줄에서 N(행)과 M(열)을 읽음
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행의 크기
        M = Integer.parseInt(st.nextToken()); // 열의 크기

        // 배열 초기화
        maze = new int[N][M]; // 미로 정보
        visited = new int[N][M]; // 방문 상태 및 최단 경로 길이

        // 미로 정보를 입력받아 배열에 저장
        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 한 줄씩 읽음
            for (int j = 0; j < M; j++) {
                // 각 문자를 숫자로 변환하여 미로 배열에 저장
                maze[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }

        // BFS 를 통해 최단 경로 계산 후 결과 출력
        System.out.println(BFS());
    }

    static int BFS() {
        // BFS 탐색을 위한 큐
        Queue<int[]> que = new ArrayDeque<>();

        // 시작 지점 (0, 0)에서 시작
        que.add(new int[]{0, 0});
        visited[0][0] = 1; // 시작 지점 방문 처리 (거리 = 1)

        // 큐가 빌 때까지 반복
        while (!que.isEmpty()) {
            // 현재 위치를 큐에서 꺼냄
            int[] now = que.poll();

            // 네 방향으로 탐색 (상, 하, 좌, 우)
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d]; // 다음 x 좌표
                int ny = now[1] + dy[d]; // 다음 y 좌표

                // 유효한 범위를 벗어나는 경우 무시
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                // 벽인 경우 무시 (maze[nx][ny] == 0)
                if (maze[nx][ny] == 0) {
                    continue;
                }

                // 이미 방문한 경우 무시
                if (visited[nx][ny] != 0) {
                    continue;
                }

                // 방문 처리: 이전 위치에서의 거리 + 1
                visited[nx][ny] = visited[now[0]][now[1]] + 1;

                // 다음 위치를 큐에 추가
                que.add(new int[]{nx, ny});
            }
        }

        // 도착 지점(N-1, M-1)에서의 최단 경로 길이 반환
        return visited[N - 1][M - 1];
    }
}