package algo1105;

import java.io.*;
import java.util.*;

public class Main_1939_중량제한 {
	static int N, M;
	static int start, end;
	static List<int[]>[] bridges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bridges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			bridges[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			bridges[a].add(new int[] { b, c });
			bridges[b].add(new int[] { a, c });
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		int ans = 0;
		int left = 1;
		int right = 1000000000;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (chk(mid)) {
				ans = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

	static boolean chk(int C) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == end)
				return true;
			for (int[] next : bridges[cur]) {
				if (visited[next[0]] || next[1] < C)
					continue;
				q.offer(next[0]);
				visited[next[0]] = true;
			}
		}
		return false;
	}
}
