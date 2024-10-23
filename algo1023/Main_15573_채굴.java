package algo1023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_15573_채굴{
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int N, M, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> map[o1[0]][o1[1]] - map[o2[0]][o2[1]]);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0 || j == 0 || j == M - 1) {
					pq.add(new int[] { i, j });
					visited[i][j] = true;
				}
				
			}
		}

		int cnt = 0;
		int max = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			max = Math.max(max, map[r][c]);
			cnt++;
			if (cnt == K) {
				System.out.println(max);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
					continue;
				pq.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}
	}
}