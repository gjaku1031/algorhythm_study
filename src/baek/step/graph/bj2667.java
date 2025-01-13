package baek.step.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> houseNum;
    static int[][] houses;
    static boolean[][] visited;
    static StringTokenizer st;
    static int count;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        houses = new int[N][N];
        visited = new boolean[N][N];
        houseNum = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                houses[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count = 0;
                if (houses[i][j] == 1 && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    search(i, j);
                    houseNum.add(count);
                }
            }
        }

        // 0만 list 로 생성해서 삭제하기
        houseNum.removeAll(List.of(0));
        Collections.sort(houseNum);
        System.out.println(houseNum.size());
        for (Integer i : houseNum) {
            System.out.println(i);
        }
    }

    public static void search(int x, int y) {
        // 위
        if (y > 0 && !visited[x][y - 1] && houses[x][y - 1] == 1) {
            count++;
            visited[x][y - 1] = true;
            search(x, y - 1);
        }

        // 아래
        if (y < N - 1 && !visited[x][y + 1] && houses[x][y + 1] == 1) {
            count++;
            visited[x][y + 1] = true;
            search(x, y + 1);
        }

        // 왼쪽
        if (x > 0 && !visited[x - 1][y] && houses[x - 1][y] == 1) {
            count++;
            visited[x - 1][y] = true;
            search(x - 1, y);
        }

        //오른쪽
        if (x < N - 1 && !visited[x + 1][y] && houses[x + 1][y] == 1) {
            count++;
            visited[x + 1][y] = true;
            search(x + 1, y);
        }
    }
}
