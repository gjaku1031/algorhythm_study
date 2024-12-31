package baek.step.math1;

import java.io.*;
import java.util.StringTokenizer;

public class bj2869 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        if ((V - B) % (A - B) == 0) {
            System.out.println((V - B) / (A - B));
        } else {
            System.out.println((V - B) / (A - B) + 1);
        }
        bw.flush();
        bw.close();
    }
}
