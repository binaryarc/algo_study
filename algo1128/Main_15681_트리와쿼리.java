package algo1128;

import java.io.*;
import java.util.*;

public class Main_15681_트리와쿼리 {
	static int N, R, Q;
	static List<Integer>[] graph;
	static int[] ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		ans = new int[N + 1];
		dfs(R, -1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int root = Integer.parseInt(st.nextToken());
			sb.append(ans[root]).append('\n');
		}
		System.out.println(sb);
	}

	public static void dfs(int cur_v, int prev_v) {
		ans[cur_v] = 1;

		if (graph[cur_v].size() >= 1) {
			for (int next : graph[cur_v]) {
				if (next == R || next == prev_v)
					continue;
				dfs(next, cur_v);
				ans[cur_v] += ans[next];
			}
			return;
		} else {
			return;
		}
	}
}
