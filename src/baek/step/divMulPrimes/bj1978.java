package baek.step.divMulPrimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += isPrime(arr[i]);
        }
        System.out.println(sum);

    }

    static int isPrime(int N) {
        int count = 0;
        for (int i = 2; i < N; i++) {
            if (N % i == 0) {
                count++;
            }
        }
        return count == 0 && N != 1 ? 1 : 0;
    }

}
