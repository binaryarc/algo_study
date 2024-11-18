package algo1103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1520_내리막길 {
	static int N, M;
	static int[][] map;
	static int[][] ans;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				ans[i][j] = -1;
			}
		}
		System.out.println(dfs(0,0));
	}

	static int dfs(int r, int c) {
		if (r == N - 1 && c == M - 1) {
			return 1;
		}

		if (ans[r][c] != -1) {
			return ans[r][c];
		}

		ans[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] < map[r][c]) {
				ans[r][c] += dfs(nr, nc);
			}
		}
		return ans[r][c];
	}
}
