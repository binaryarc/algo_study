package algo250219;

import java.io.*;
import java.util.*;

public class Main_15663_N과M9 {
	static int N, M;
	static int[] arr;
	static Set<Integer> set;
	static List<Integer> list;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		set = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		list = new ArrayList<>();
		list.addAll(set);

		sb = new StringBuilder();
		backtrack(0, 0, new int[M]);
		System.out.println(sb);
	}

	public static void backtrack(int start, int idx, int[] arr) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			arr[idx] = list.get(i);
			backtrack(i + 1, idx + 1, arr);
		}

	}
}
