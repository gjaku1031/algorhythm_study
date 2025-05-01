package sw.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class sw6730 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> up = new ArrayList<>();
            ArrayList<Integer> down = new ArrayList<>();



            for (int i = 0; i < N - 1; i++) {
                if (arr[i + 1] > arr[i]) {
                    up.add(arr[i + 1] - arr[i]);
                } else if (arr[i + 1] < arr[i]) {
                    down.add(arr[i] - arr[i + 1]);
                } else {
                    up.add(0);
                    down.add(0);
                }
            }
            int upMax = up.isEmpty() ? 0 : Collections.max(up);
            int downMax = down.isEmpty() ? 0 : Collections.max(down);
            System.out.println("#" + tc + " " + upMax + " " + downMax);


        }
    }
}
