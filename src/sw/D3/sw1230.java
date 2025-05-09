package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sw1230 {
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
                String command = st.nextToken();


                if (command.equals("I")) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    command_I(a, b);
                } else if (command.equals("D")) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    command_D(a, b);
                } else {
                    int a = Integer.parseInt(st.nextToken());
                    command_A(a);
                }
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }

    }

    private static void command_I(int a, int b) {
        for (int j = 0; j < b; j++) {
            list.add(a + j, Integer.parseInt(st.nextToken()));
        }
    }

    private static void command_D(int a, int b) {
        for (int j = 0; j < b; j++) {
            list.remove(a + 1);
        }
    }

    private static void command_A(int a) {
        for (int j = 0; j < a; j++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
    }


}
