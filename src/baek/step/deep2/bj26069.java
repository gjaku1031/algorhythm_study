package baek.step.deep2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj26069 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        set.add("ChongChong");
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String line1 = st.nextToken();
            String line2 = st.nextToken();
            if (!set.contains(line1) && !set.contains(line2)) {
                continue;
            }
            set.add(line1);
            set.add(line2);
        }
        System.out.println(set.size());
    }
}
