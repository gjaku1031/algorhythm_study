package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class sw5650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;

    // 방향: 0=상, 1=하, 2=좌, 3=우
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    // 블록(1~5) 반사 테이블 [block][direction] -> newDirection
    // 인덱스 0은 사용 안 함
    static final int[][] REFLECT = {
            {0, 0, 0, 0},       // dummy
            {1, 3, 0, 2},       // block 1
            {3, 0, 1, 2},       // block 2
            {2, 0, 3, 1},       // block 3
            {1, 2, 3, 0},       // block 4
            {1, 0, 3, 2}        // block 5 (정반사)
    };

    static int[][] board;   // (N+2) x (N+2), 외곽은 모두 5
    static int[][] whR;     // 웜홀 목적지 r
    static int[][] whC;     // 웜홀 목적지 c

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder(64 * T);

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            // 보드와 웜홀 매핑 초기화
            board = new int[N + 2][N + 2];
            whR = new int[N + 2][N + 2];
            whC = new int[N + 2][N + 2];

            // 외곽을 블록 5로 설정 (경계 체크 제거)
            for (int i = 0; i < N + 2; i++) {
                board[0][i] = 5;
                board[N + 1][i] = 5;
                board[i][0] = 5;
                board[i][N + 1] = 5;
            }

            // 웜홀 좌표 저장용 (두 좌표)
            int[] w1r = new int[11], w1c = new int[11];
            int[] w2r = new int[11], w2c = new int[11];
            for (int i = 6; i <= 10; i++) {
                w1r[i] = w1c[i] = w2r[i] = w2c[i] = -1;
            }

            // 입력 보드를 1..N 범위에 채운다
            for (int r = 1; r <= N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 1; c <= N; c++) {
                    int val = Integer.parseInt(st.nextToken());
                    board[r][c] = val;

                    if (val >= 6 && val <= 10) {
                        if (w1r[val] == -1) {
                            w1r[val] = r; w1c[val] = c;
                        } else {
                            w2r[val] = r; w2c[val] = c;
                        }
                    }
                }
            }

            // 웜홀 매핑 구성: 각 웜홀 칸에서 바로 짝 좌표로 이동
            for (int v = 6; v <= 10; v++) {
                if (w1r[v] != -1 && w2r[v] != -1) {
                    int r1 = w1r[v], c1 = w1c[v];
                    int r2 = w2r[v], c2 = w2c[v];
                    whR[r1][c1] = r2; whC[r1][c1] = c2;
                    whR[r2][c2] = r1; whC[r2][c2] = c1;
                }
            }

            int answer = 0;

            // 모든 빈 칸(0)에서 4방향으로 시뮬레이션
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    if (board[r][c] != 0) continue;
                    for (int d = 0; d < 4; d++) {
                        int score = simulate(r, c, d);
                        if (score > answer) answer = score;
                    }
                }
            }

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(sb);
    }

    static int simulate(int sr, int sc, int sd) {
        int r = sr;
        int c = sc;
        int d = sd;
        int score = 0;

        while (true) {
            // 한 칸 전진
            r += dr[d];
            c += dc[d];

            int cell = board[r][c];

            // 시작점으로 돌아오거나 블랙홀(-1) 도달 시 종료
            if ((r == sr && c == sc) || cell == -1) {
                return score;
            }

            if (cell == 0) {
                // 빈 칸: 계속 진행
                continue;
            }

            if (1 <= cell && cell <= 5) {
                // 블록 반사
                score++;
                d = REFLECT[cell][d];
                // 현재 위치는 블록 칸에 머문 상태에서 방향만 바뀜
                // 다음 루프에서 바뀐 방향으로 이동
            } else {
                // 웜홀(6~10): 짝 위치로 즉시 이동
                int nr = whR[r][c];
                int nc = whC[r][c];
                r = nr;
                c = nc;
                // 방향은 유지
            }
        }
    }
}
