package baek.step.setMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            if (str2.equals("enter")) {
                set.add(str1);
            } else if (str2.equals("leave")) {
                set.remove(str1);
            }
        }

        LinkedList<String> tempList = new LinkedList<>(set);
        Collections.sort(tempList,Collections.reverseOrder());
        for (String s : tempList) {
            System.out.println(s);
        }
    }
}