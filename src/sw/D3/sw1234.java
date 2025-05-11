package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1234 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String pwd = st.nextToken();
            while (true) {
                StringBuilder sb = new StringBuilder();
                boolean exit = true;
                for (int i = 0; i < pwd.length(); i++) {
                    if (i < pwd.length() - 1 && pwd.charAt(i) == pwd.charAt(i + 1)) {
                        exit = false;
                        i++;
                    } else {
                        sb.append(pwd.charAt(i));
                    }
                }
                pwd = sb.toString();

                if (exit) {
                    break;
                }
            }
            System.out.println("#" + tc + " " + pwd);
        }
    }
}