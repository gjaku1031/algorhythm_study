package baek.bronze.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int C = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken()); // 학생 수
            int[] scores = new int[N];
            
            // 점수 입력 받기
            for (int j = 0; j < N; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
            }
            
            // 평균 계산
            double sum = 0;
            for (int j = 0; j < N; j++) {
                sum += scores[j];
            }
            double average = sum / N;
            
            // 평균을 넘는 학생 수 카운트
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (scores[j] > average) {
                    count++;
                }
            }
            
            // 비율 계산 및 출력
            double ratio = (double) count / N * 100;
            System.out.printf("%.3f%%\n", ratio);
        }
        
        br.close();
    }
}
