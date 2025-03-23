package algo250303;

import java.io.*;
import java.util.*;

public class Main_15663_N과M9 {
	static int N, M;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		list = new ArrayList<>();
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int cnt) {
		if (cnt == M) {
			for (int n : list) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int prev = -1;

		for (int i = 0; i < N; i++) {
			if(visited[i] || prev == arr[i])continue;
			list.add(arr[i]);
			visited[i] = true;
			prev = arr[i];
			dfs(cnt+1);
			list.remove(list.size()-1);
			visited[i] = false;
		}
	}
}
