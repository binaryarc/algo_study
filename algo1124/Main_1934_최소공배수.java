package algo1124;

import java.util.Scanner;

public class Main_1934_최소공배수 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- != 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(lcm(Math.max(a, b), Math.min(a, b)));
		}
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}
