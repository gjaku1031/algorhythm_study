package baek.setMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class bj11478 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i <= S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                //System.out.println(S.substring(i, j));
                result.add(S.substring(i, j));
            }
        }
        System.out.println(result.size());
    }
}
