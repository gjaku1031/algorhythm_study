package baek.bronze.B1;

import java.util.Scanner;

public class bj1924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int month = sc.nextInt();
        int day = sc.nextInt();
        
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        String[] dayOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        
        int totalDays = 0;
        
        for (int i = 1; i < month; i++) {
            totalDays += daysInMonth[i];
        }
        
        totalDays += day;
        
        System.out.println(dayOfWeek[totalDays % 7]);
    }
}
