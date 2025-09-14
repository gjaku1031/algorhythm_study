package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(br.readLine());

        double euclideanCircleArea = Math.PI * R * R;

        double taxiCabCircleArea = 2.0 * R * R;

        System.out.printf("%.6f%n", euclideanCircleArea);
        System.out.printf("%.6f%n", taxiCabCircleArea);
    }
}
