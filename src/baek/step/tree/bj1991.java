package baek.step.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] chList;
    static int N;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        chList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            chList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            if (b != '.') {
                chList[a - 65].add(b - 65);
            }
            if (c != '.') {
                chList[a - 65].add(c - 65);
            }
        }

        for (ArrayList<Integer> integers : chList) {
            System.out.println(integers);
        }
        preorder(0);
    }

    static void preorder(int n) {
        if (chList[n].isEmpty()) {
            return;
        }
        System.out.print((char) (n + 65));
        preorder(chList[n].get(0));
        if (chList[n].size() > 1) {
            preorder(chList[n].get(1));
        }
    }
}