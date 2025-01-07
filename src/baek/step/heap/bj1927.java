package baek.step.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a != 0) {
                pQue.offer(a);
            } else if (!pQue.isEmpty()) {
                System.out.println(pQue.poll());;
            } else {
                System.out.println(0);
            }
        }

    }

}
