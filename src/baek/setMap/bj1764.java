package baek.setMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> unheard = new HashSet<>();
        HashSet<String> unseen = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            unheard.add(str);
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            unseen.add(str);
        }

        HashSet<String> unheardUnSeen = new HashSet<>(unheard);
        unheardUnSeen.retainAll(unseen);
        System.out.println(unheardUnSeen.size());

        List<String> tempList = new ArrayList<>(unheardUnSeen);
        Collections.sort(tempList);
        for (String s : tempList) {
            System.out.println(s);
        }
    }
}
