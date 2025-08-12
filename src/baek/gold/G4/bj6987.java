package baek.gold.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj6987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] team;
    static boolean[] visited;
    static int[] order;

    public static void main(String[] args) throws IOException {
        for (int tc = 0; tc < 4; tc++) {
            // 입력
            st = new StringTokenizer(br.readLine());

            team = new int[6][3];
            for (int i = 0; i < 6; i++) {
                team[i][0] = Integer.parseInt(st.nextToken());
                team[i][1] = Integer.parseInt(st.nextToken());
                team[i][2] = Integer.parseInt(st.nextToken());
            }

            // 백트래킹
            visited = new boolean[6];
            order = new int[6];
            bt(0);
        }
    }

    static void bt(int level) {
        if (level == 6) {
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[level] = i;
                bt(level + 1);
                visited[i] = false;
            }
        }
    }
}
