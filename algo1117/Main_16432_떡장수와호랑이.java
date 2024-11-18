package algo1117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16432_떡장수와호랑이 {
	static boolean[][] visited;
	static List<Integer>[] list;
	static int[] ans;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][10];
		list = new ArrayList[N + 1];
		ans = new int[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++)
				list[i].add(Integer.parseInt(st.nextToken()));
		}
		visited = new boolean[N + 1][10];
		dfS(1, -1);
		System.out.println(-1);
	}

	public static void dfS(int day, int prev) {
		if (day > N) {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= N; i++) {
				sb.append(ans[i]).append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}

		for (int n : list[day]) {
			if (n == prev || visited[day][n])
				continue;
			visited[day][n] = true;
			ans[day] = n;
			dfS(day + 1, n);
		}
	}
}
