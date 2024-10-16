package algo1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926_그림 {
	static int N, M;
	static int[][] map;
	static int cnt;
	static int big_size;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		big_size = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(big_size);
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { r, c });
		map[r][c] = 0;
		int size = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0)
					continue;
				q.offer(new int[] { nr, nc });
				map[nr][nc] = 0;
				size++;
			}
		}
		if(size > big_size)big_size = size;
		return;
	}
}
