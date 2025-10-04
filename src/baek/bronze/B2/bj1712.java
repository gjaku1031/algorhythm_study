package baek.bronze.B2;

import java.util.Scanner;

public class bj1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // 고정 비용
		int B = sc.nextInt(); // 가변 비용
		int C = sc.nextInt(); // 판매 가격

		if (B >= C) {
			System.out.println(-1);
		} else {
			System.out.println(A / (C - B) + 1);
		}
	}
}
