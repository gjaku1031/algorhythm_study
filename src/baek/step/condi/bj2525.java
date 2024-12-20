package baek.step.condi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int cook = Integer.parseInt(br.readLine());
        Clock clock = new Clock(hour, minute);
        clock.showTimer(cook);
    }

    static class Clock {
        int hour;
        int minute;

        public Clock(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        public void showTimer(int cook) {
            minute += cook;
            if (minute >= 60) {
                hour += minute / 60;
                if (hour >= 24) {
                    hour -= 24;
                }
                minute %= 60;
            }
            System.out.println(hour + " " + minute);
        }
    }
}