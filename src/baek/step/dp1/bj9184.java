package baek.step.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj9184 {
    static StringTokenizer st;
    static int[][][] w = new int[51][51][51];


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        w[50][50][50] = 1048576;


        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            if (a <= 0 || b <= 0 || c <= 0) {
                System.out.println(1);
            }

            if (a > 20 || b > 20 || c > 20) {
                System.out.println(w[50][50][50]);
            }
        }
    }
}

/*
if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
    1w

if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
    w(20, 20, 20)
ㅔ
if a < b and b < c, then w(a, b, c) returns:
    w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)

otherwise it returns:
    w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
 */