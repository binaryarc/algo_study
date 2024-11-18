package algo1111;

import java.io.*;
import java.util.*;

public class Main_17142_연구소3 {
	static int N, M;
	static int[][] map;
	static List<int[]> virusPosition;
	static int ans;
	static int L;
	static int[] temp;
	static int[] dr = { -1, 1, 0, 0, };
	static int[] dc = { 0, 0, -1, 1 };
	static int availCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		virusPosition = new ArrayList<>();
		availCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusPosition.add(new int[] { i, j });
				}
				if (map[i][j] == 0)
					availCnt++;
			}
		}
		L = virusPosition.size();
		temp = new int[M];
		ans = Integer.MAX_VALUE;
		dfs(0, 0);
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

	static void dfs(int cnt, int idx) {
		if (cnt == M) {
			ans = Math.min(ans, bfs());
			return;
		}

		for (int i = idx; i < L; i++) {
			temp[cnt] = i;
			dfs(cnt + 1, i + 1);
		}

	}

	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			int[] cur = virusPosition.get(temp[i]);
			q.add(new int[] { cur[0], cur[1], 0 });
			visited[cur[0]][cur[1]] = true;
		}

		int cnt = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(map[cur[0]][cur[1]]==0) {
				cnt++;
			}
			
			if (cnt == availCnt) {
				return cur[2];
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
					continue;
				if (map[nr][nc] == 1)
					continue;
				q.offer(new int[] { nr, nc, cur[2] + 1 });
				visited[nr][nc] = true;
			}
		}

		return Integer.MAX_VALUE;
	}

}
