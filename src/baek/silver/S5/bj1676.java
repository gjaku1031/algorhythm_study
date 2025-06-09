package baek.silver.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1676 {
    static int count_two = 0;
    static int count_five = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            setCount_two(i);
            setCount_five(i);
        }
        System.out.println(Math.min(count_two, count_five));
    }
    static void setCount_two(int i){
        int temp = i;
        while (temp % 2 == 0) {
            temp /= 2;
            count_two++;
        }
    }
    static void setCount_five(int i){
        int temp = i;
        while (temp % 5 == 0) {
            temp /= 5;
            count_five++;
        }
    }

}
