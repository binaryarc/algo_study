package algo1124;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2090_조화평균 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		//최소 공배수 구하기
		long lcmRes = arr[0];
		for (int i = 1; i < N; i++) {
			lcmRes = lcm(lcmRes, arr[i]);
		}
		
		//분자 계산하기
		long num = 0;
		for (int i = 0; i < N; i++) {
			num += (lcmRes / arr[i]);
		}
		long x = gcd(num,lcmRes);
		
		System.out.println((lcmRes/x) + "/" + (num/x));

	}

	public static long gcd(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}
}
