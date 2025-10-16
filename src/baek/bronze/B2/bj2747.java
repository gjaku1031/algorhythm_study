package baek.bronze.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        System.out.println(fibo(n));
    }
    
    static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        
        int a = 0;
        int b = 1;
        int result = 0;
        
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        
        return result;
    }
}
