package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class sw9280 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int n, m;
    static int[] R;
    static int[] W;

    static Deque<Integer> deq;
    static int[] park;
    static int result;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            deq = new ArrayDeque<>();
            park = new int[n];
            result = 0;
            R = new int[n];
            W = new int[m];

            for (int i = 0; i < n; i++) {
                R[i] = Integer.parseInt(br.readLine());

            }

            for (int i = 0; i < m; i++) {
                W[i] = Integer.parseInt(br.readLine());
            }

            System.out.println("==== 주차 시작 ====");
            for (int i = 0; i < 2 * m; i++) {
                int car_idx = Integer.parseInt(br.readLine());

                if (car_idx > 0) {
                    System.out.println("차량 번호 = " + car_idx + " 들어옴");
                    parkstatus();
                    if (!search(car_idx)) {
                        deq.add(car_idx);
                        System.out.println("차량 번호 = " + car_idx + " search 실패후 줄섬");
                        parkstatus();
                    }
                } else {
                    int out = car_idx * (-1) - 1;

                    // 요금 계산후 나감
                    result += R[park[out]] * W[out];
                    park[out] = 0;
                    System.out.println("차량 번호 = " + out + " 계산후 나감");

                    // 대기 차량 없으면
                    if (deq.isEmpty()) {
                        System.out.println("줄 선 차량 없어서 다음");
                        continue;
                    }

                    int in = deq.peek();
                    if (search(in)) {
                        deq.pop();
                    }
                }

            }

            System.out.println("#" + tc + " ");
        }
    }

    static boolean isParkEmpty() {
        for (int i = 0; i < n; i++) {
            if (park[i] != 0) {
                return false;
            }
        }
        return true;
    }

    static boolean search(int car_idx) {
        int car = car_idx - 1;

        // 자리 탐색
        int min = Integer.MAX_VALUE;
        int min_idx = -1;
        for (int j = 0; j < n; j++) {
            if (min > R[j] && park[j] == 0) {
                min_idx = j;
                min = R[j];
            }
        }

        // 자리 탐색 실패시
        if (min_idx == -1) {
            return false;
        } else {
            park[min_idx] = car;
            System.out.println("차량 번호 = " + car + "주차함");
            parkstatus();
            return true;
        }

    }

    static void parkstatus() {
        for (int i : park) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("============");
    }

    static int findOutIdx() {
        return 0;
    }
}
