package baek.step.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 1차원 배열로 퀸의 위치 저장 - arr[i] = j는 i행 j열에 퀸이 있다는 의미
    static int[] queens;
    static int count = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        queens = new int[N];
        nQueen(0);
        System.out.println(count);
    }
    
    static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }
        
        // depth번째 행의 각 열에 퀸을 놓아보기
        for (int i = 0; i < N; i++) {
            queens[depth] = i;
            
            // 현재 위치에 퀸을 놓을 수 있는지 체크
            if (isValid(depth)) {
                nQueen(depth + 1);
            }
        }
    }
    
    static boolean isValid(int depth) {
        for (int i = 0; i < depth; i++) {
            // 같은 열에 있는지 체크
            if (queens[depth] == queens[i]) {
                return false;
            }
            
            // 대각선에 있는지 체크
            // 행의 차이와 열의 차이가 같으면 대각선상에 위치
            if (Math.abs(queens[depth] - queens[i]) == Math.abs(depth - i)) {
                return false;
            }
        }
        return true;
    }
}