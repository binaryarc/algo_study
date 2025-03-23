package algo250219;

import java.io.*;
import java.util.*;

public class Main_2023_신기한소수 {
	static int N;
	static StringBuilder sb;
	static char[] chkChar;
	static int[] candidate = { 2, 3, 5, 7 };

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sb = new StringBuilder();
		chkChar = new char[N];

		for (int start : candidate) {
			makeNum(start, 1);
		}
		System.out.println(sb);
	}

	public static void makeNum(int num, int cnt) {
		if (cnt == N) {
			if (isPrime(num))
				sb.append(num).append("\n");
			return;
		}

		for (int i = 1; i <= 9; i += 2) {
			if (!isPrime(num * 10 + i))
				continue;
			makeNum(num * 10 + i, cnt + 1);
		}

	}

	public static boolean isPrime(int num) {
		if (num < 2)
			return false;
		int sqrt = (int) Math.sqrt(num);
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
