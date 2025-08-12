package baek.silver.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj19622 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static Sit[] sit;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        sit = new Sit[N];
        dp = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int man = Integer.parseInt(st.nextToken());
            sit[i] = new Sit(start, end, man);
        }

        for (int i = 1; i < N; i++) {

        }

    }

    static class Sit implements Comparable<Sit>{
        int start;
        int end;
        int man;

        public Sit(int start, int end, int man) {
            this.start = start;
            this.end = end;
            this.man = man;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getMan() {
            return man;
        }

        @Override
        public int compareTo(Sit sit) {
            return sit.getEnd() - this.end;
        }
    }
}