package baek.gold.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11444 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());


    }

    static void recur(int[] mat, int n) {

    }

    static void multi(int[] mat) {
        int[] next_mat = new int[4];
        next_mat[0] = mat[0] * mat[0] + mat[1] * mat[2];
        next_mat[1] = mat[0] * mat[1] + mat[2] * mat[3];
        next_mat[2] = mat[1] * mat[1] + mat[3] * mat[3];
        next_mat[3] = mat[0] * mat[3] + mat[2] * mat[1];
    }
}
/*
an an+1  1 1    an + an+1 a
0  0     1 2
 */


