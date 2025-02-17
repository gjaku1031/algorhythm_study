package baek.step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj17219 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static HashMap<String, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String line1 = st.nextToken();
            String line2 = st.nextToken();
            map.put(line1, line2);
        }
        while (M-- > 0) {
            String line = br.readLine();
            sb.append(map.get(line)).append("\n");
        }
        System.out.println(sb);
    }
}
