package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1912_Kadane {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int currentMax = arr[0]; // 현재 인덱스에서 끝나는 최대 연속합
        int overallMax = arr[0]; // 전체 배열에서의 최대 연속합

    
        for (int i = 1; i < n; i++) {
            // 현재 원소에서 새로 시작할지, 이전 연속합에 이어붙일지 결정
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            
            // 전체 최대값 업데이트
            overallMax = Math.max(overallMax, currentMax);
        }

        System.out.println(overallMax);
    }

}
