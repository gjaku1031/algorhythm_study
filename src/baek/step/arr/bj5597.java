package baek.step.arr;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bj5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[30];
        for (int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[n - 1] = n;
        }
        for (int i = 0; i < 30; i++) {
            if (arr[i] == 0) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}
