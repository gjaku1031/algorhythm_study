package baek.step.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj24060 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] A, tmp;
    static int count = 0;
    static int result = -1;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);
        System.out.println(result);

    }

    static void mergeSort(int p, int r) {
        if (count >= K) {
            return;
        }

        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    static void merge(int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        while (i <= q) {
            tmp[t++] = A[i++];
        }
        while (j <= r) {
            tmp[t++] = A[j++];
        }

        i = p;
        t = 0;
        while (i <= r) {
            if (count >= K) {
                return;
            }
            A[i] = tmp[t];
            count++;
            if (count == K) {
                result = A[i];
            }
            i++;
            t++;
        }
    }
}
