package baek.bronze.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.StringTokenizer;

public class bj10824 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] arr = new String[4];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = st.nextToken();
        }
        long a = Long.parseLong(arr[0] + arr[1]);
        long b = Long.parseLong(arr[2] + arr[3]);
        System.out.println(a + b);
    }
}