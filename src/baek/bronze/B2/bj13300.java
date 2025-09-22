package baek.bronze.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13300 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[][] arr = new int[7][2];

    public static void main(String[] args) throws IOException {
        //입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gen = Integer.parseInt(st.nextToken());
            int cls = Integer.parseInt(st.nextToken());
            arr[cls][gen]++;
        }

        //풀이
        int result = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) {
                result += (arr[i][j] + (K - 1)) / K;
            }
        }
        System.out.println(result);
    }

}
/*
(정독)
2박 3일 수학여행
여러 학년 같은 장소
1학년부터 6학년까지 학생들 묵을 방 배정

남학생끼리, 여학생끼리
한 방에는 같은 학년의 학생 배정 -> 한 방에 한 명만 가능

한 방에 배정할 수 있는 최대 인원 수 K

조건에 맞게 모든 학생을 배정하기 위해 필요한 방의 최소 개수를 구하라

==========================================================
예시)
 */

/*
0 - 0

1
2
3

4
5
6
 */