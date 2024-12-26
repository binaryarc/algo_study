package algo1124;

import java.util.Scanner;

public class Main_2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int gcd = gcd(Math.max(a, b), Math.min(a, b));
		int lcm = lcm(Math.max(a, b), Math.min(a, b));
		System.out.println(gcd);
		System.out.println(lcm);
	}

	// a > b 일때 사용, 유클리드 호재법
	// 최대 공약수
	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	// 최소 공배수
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}
