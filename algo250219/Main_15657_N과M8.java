package algo250219;

import java.io.*;
import java.util.*;

public class Main_15657_N과M8 {
	static int N, M;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		backtrack(0, 0, new int[M]);
		System.out.println(sb);
	}

	public static void backtrack(int idx, int start, int[] fArr) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(fArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			fArr[idx] = arr[i];
			backtrack(idx + 1,i, fArr);
		}
	}
}
