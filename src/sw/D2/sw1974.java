package sw.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class sw1974 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static StringTokenizer st;
    static int result;

    static Set<Integer>[] row = new Set[9];
    static Set<Integer>[] col = new Set[9];
    static Set<Integer>[] block = new Set[9];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            int[][] sudoku = new int[9][9];

            for (int i = 0; i < 9; i++) {
                row[i] = new HashSet<>();
                col[i] = new HashSet<>();
                block[i] = new HashSet<>();
            }

            result = 1;

            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                    row[i].add(sudoku[i][j]);
                    col[j].add(sudoku[i][j]);

                    int blockIndex = (i / 3) * 3 + (j / 3);
                    block[blockIndex].add(sudoku[i][j]);
                }
            }

            for (int i = 0; i < 9; i++) {
                if (!check(row[i]) || !check(col[i]) || !check(block[i])) {
                    result = 0;
                    break;
                }
            }

            System.out.println("#" + tc + " " + result);

        }
    }

    static boolean check(Set<Integer> nums) {
        return nums.size() == 9;
    }
}