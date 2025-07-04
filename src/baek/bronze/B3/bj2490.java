package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2490 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        // 총 3번의 테스트 케이스를 반복합니다.
        for (int tc = 0; tc < 3; tc++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            // 4개의 윷 상태를 읽어 합계를 구합니다.
            for (int i = 0; i < 4; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            // --- 여기부터 완성된 부분 ---

            // sum은 등이 나온 개수(1의 개수)입니다.
            // 문제의 조건은 배가 나온 개수(0의 개수)를 기준으로 합니다.
            // 스위치 문을 사용하여 sum 값에 따라 결과를 출력합니다.
            switch (sum) {
                case 0: // 등 0개, 배 4개 -> 윷(D)
                    System.out.println("D");
                    break;
                case 1: // 등 1개, 배 3개 -> 걸(C)
                    System.out.println("C");
                    break;
                case 2: // 등 2개, 배 2개 -> 개(B)
                    System.out.println("B");
                    break;
                case 3: // 등 3개, 배 1개 -> 도(A)
                    System.out.println("A");
                    break;
                case 4: // 등 4개, 배 0개 -> 모(E)
                    System.out.println("E");
                    break;
            }
        }
    }
}