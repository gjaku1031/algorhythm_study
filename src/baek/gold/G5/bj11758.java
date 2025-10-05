package baek.gold.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11758 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int[][] point = new int[4][2];

  public static void main(String[] args) throws IOException {
    for (int i = 1; i <= 3; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      point[i] = new int[] {a, b};
    }

    int CCW = (point[2][0] - point[1][0]) * (point[3][1] - point[1][1]) - (point[2][1] - point[1][1]) * (point[3][0] - point[1][0]);

    if (CCW > 0) {
      System.out.println(1);
    } else if (CCW == 0) {
      System.out.println(0);
    } else {
      System.out.println(-1);
    }
  }
}