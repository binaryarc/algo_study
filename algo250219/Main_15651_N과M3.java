package algo250219;

import java.util.Scanner;

public class Main_15651_N과M3 {
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sb = new StringBuilder();
		backtrack(0, new int[M]);
		System.out.println(sb);
	}

	public static void backtrack(int idx, int[] arr) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			arr[idx] = i;
			backtrack(idx + 1, arr);
		}
	}
}
