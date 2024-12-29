package goorumTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class begin2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int candi = Integer.parseInt(st.nextToken());
            vote(s, candi, arr);
        }
        int top = Arrays.stream(arr).max().getAsInt();
        for (int i = 0; i < 9; i++) {
            if (arr[i] == top) {
                System.out.println(i + 1);
                break;
            }
        }
    }
    static void vote(String s, int candi, int[] arr) {

        int vote;
        if (s.equals("A")) {
            vote = 3;
        } else if (s.equals("B")) {
            vote = 2;
        } else {
            vote = 1;
        }
        arr[candi - 1] += vote;
    }
}
