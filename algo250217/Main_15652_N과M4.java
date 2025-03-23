package algo250217;

import java.io.*;
import java.util.*;

public class Main_15652_N과M4 {
	static int N, M;
	static StringBuilder sb;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		list = new ArrayList<>();
		backtrack(1, 0);
		System.out.println(sb);
	}

	private static void backtrack(int idx, int cnt) {
		if (cnt == M) {
			for (int n : list) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i <= N; i++) {
			list.add(i);
			backtrack(i, cnt+1);
			list.remove(list.size()-1);
		}

	}
}
