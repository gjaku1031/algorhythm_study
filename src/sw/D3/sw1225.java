package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class sw1225 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Deque<Integer> deq;


    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            deq = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                deq.addLast(Integer.parseInt(st.nextToken()));
            }
            encode();
            System.out.print("#" + tc + " ");
            for (Integer i : deq) {
                System.out.print(i + " ");
            }
        }
    }

    static void encode() {
        int count = 1;
        while (true) {
            for (int i = 0; i < 5; i++) {
                if (count > 5) {
                    count = 1;
                }
                int a = deq.pollFirst();
                int next = a - count;
                if (next <= 0) {
                    deq.addLast(0);
                    return;
                } else {
                    deq.addLast(next);
                }
                count++;
            }
        }
    }
}
