package baek.step.deep2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        System.out.println(list.get(0) * list.get(list.size()) - 1);
    }
}