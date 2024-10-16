package algo1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20165_인내의도미노장인호석 {
	static int N, M, R;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] isDown;
	static int score;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken()); // 라운드

		map = new int[N+1][M+1];
		isDown = new boolean[N+1][M+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		score = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			if(!isDown[r][c]) {
				simul(r, c, d);
			}

			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			isDown[r][c] = false;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(isDown[i][j]) {
					sb.append("F ");
				}else {
					sb.append("S ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(score);
		System.out.println(sb);
		
	}

	static void simul(int r, int c, char d) {
		int dir = -1;
		if (d == 'N') {
			dir = 0;
		} else if (d == 'S') {
			dir = 1;
		} else if (d == 'W') {
			dir = 2;
		} else {
			dir = 3;
		}
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {r,c});
		isDown[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int nr = cur[0];
			int nc = cur[1];
			score++;
			for (int i = 1; i < map[cur[0]][cur[1]]; i++) {
				nr += dr[dir];
				nc += dc[dir];
				if(nr < 1 || nr > N || nc < 1 || nc > M)continue;
				if(!isDown[nr][nc]) {
					q.offer(new int[] {nr,nc});
					isDown[nr][nc] = true;
				}
			}
		}
	}
}
