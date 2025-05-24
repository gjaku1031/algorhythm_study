package baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1931 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    static Meeting[] meetings;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings);
        int pre_end = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (pre_end <= meetings[i].getStart()) {
                pre_end = meetings[i].getEnd();
                count++;
            }
        }
        System.out.println(count);

    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (o.end != this.end) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }
    }
}
