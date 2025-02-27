package baek.step.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj24060 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int count = 0;
    static int[] tmp;
    static int N, K;
    static int[] A;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        tmp = new int[N]; // 임시 배열 초기화
        merge_sort(A, 0, A.length - 1);
        System.out.println(A[K - 1]);
    }

    // 병합 정렬 함수 (A[p..r]을 오름차순 정렬)
    public static void merge_sort(int[] A, int p, int r) {
        if (p < r) {  // 배열 크기가 1보다 크면 계속 분할
            int q = (p + r) / 2; // 중간 지점 계산
            merge_sort(A, p, q);    // 전반부 정렬
            merge_sort(A, q + 1, r); // 후반부 정렬
            merge(A, p, q, r); // 병합
        }
    }

    // 두 개의 정렬된 부분을 병합하는 함수 (A[p..q]와 A[q+1..r]을 병합)
    public static void merge(int[] A, int p, int q, int r) {
        int i = p, j = q + 1, t = 0; // t는 임시 배열에서의 인덱스

        // 두 배열을 비교하면서 병합
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        // 왼쪽 배열 부분이 남은 경우
        while (i <= q) {
            tmp[t++] = A[i++];
        }

        // 오른쪽 배열 부분이 남은 경우
        while (j <= r) {
            tmp[t++] = A[j++];
        }

        // 병합된 데이터를 원래 배열에 복사
        for (i = p, t = 0; i <= r; i++, t++) {
            A[i] = tmp[t];
        }
    }
}
