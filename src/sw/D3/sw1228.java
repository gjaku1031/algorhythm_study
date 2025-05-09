package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sw1228 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10; tc++) {
            list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                for (int j = 0; j < b; j++) {
                    list.add(a + j, Integer.parseInt(st.nextToken()));
                }
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }

    }
}
