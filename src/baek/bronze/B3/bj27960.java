package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj27960 {
    // 비트마스킹 핵심 요약
    // - 과녁 점수는 1, 2, 4, 8, ... 처럼 2의 거듭제곱입니다.
    // - 어떤 사람이 맞힌 과녁들의 총합을 2진수로 보면,
    //   각 비트(0 또는 1)는 해당 점수의 과녁을 맞혔는지(1) 안 맞혔는지(0)를 나타냅니다.
    // - "A와 B 중 오직 한 명만 맞힌 과녁"들의 합 = A XOR B (비트 단위 배타적 논리합)
    //   비트별 XOR 진리표:
    //     A  B | A ^ B
    //     0  0 |   0   (둘 다 못 맞춤 → C 점수에 0)
    //     0  1 |   1   (B만 맞춤 → C 점수에 포함)
    //     1  0 |   1   (A만 맞춤 → C 점수에 포함)
    //     1  1 |   0   (둘 다 맞춤 → C 점수에 미포함)
    //
    // 예시)
    //   A = 13(2진수 1101 = 8+4+1), B = 10(2진수 1010 = 8+2)
    //   A ^ B = 0111(2진수) = 7 (4+2+1) → 오직 한 명만 맞힌 과녁들의 합
    //
    // 시간/공간 복잡도:
    //   - O(1), 정수 두 개에 대해 한 번의 XOR 연산

    public static void main(String[] args) throws Exception {
        // 입력: 한 줄에 A와 B (정수)
        // 출력: A ^ B
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().trim().split("\\s+");
        int A = Integer.parseInt(parts[0]);
        int B = Integer.parseInt(parts[1]);

        // XOR로 "둘 중 한 명만 맞힌 과녁"의 총합 계산
        System.out.println(A ^ B);
    }
}
