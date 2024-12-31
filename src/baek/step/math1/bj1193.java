package baek.step.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (findLine(N) % 2 == 0) {
            countEvenIdx(N);
            //System.out.println("Even = " + N);
        } else {
            countOddIdx(N);
            //System.out.println("Odd = " + N);
        }
    }
    // n번째 대각선 줄의 최대 인덱스 찾기
    static int findMax(int n) {
        int max = 1;
        for (int i = 0; i < n; i++) {
            max += i;
        }
        return max;
    }

    // N이 속해있는 대각선 줄 찾기
    static int findLine(int N) {
        for (int i = 1; true; i++) {
            if (findMax(i) <= N && N < findMax(i + 1)) {
                return i;
            }
        }
    }


    // 홀수 대각선 세기
    static void countOddIdx(int N) {
        // 해당 대각선줄의 첫 분수
        int count = N - findMax(findLine(N));
        int mom = 1;
        int son = findLine(N) + 1 - mom;
        for (int i = 0; i < count; i++) {
            mom++;
            son--;
        }
        System.out.println(son + "/" + mom);
    }

    // 짝수 대각선 세기
    static void countEvenIdx(int N) {
        // 해당 대각선줄의 첫 분수
        int count = N - findMax(findLine(N));

        int son = 1;
        int mom = findLine(N) + 1 - son;
        for (int i = 0; i < count; i++) {
            mom--;
            son++;
        }
        System.out.println(son + "/" + mom);
    }
}
