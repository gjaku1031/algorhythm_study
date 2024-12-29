package goorumTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class begin3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            isDivisor(a, b);
        }
    }

    static void isDivisor(int a, int b) {
        if (a % b == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
