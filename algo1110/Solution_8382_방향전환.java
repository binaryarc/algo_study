package algo1110;

import java.io.*;
import java.util.*;

public class Solution_8382_방향전환 {
	static int x1, x2, y1, y2;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;
			sb.append('#').append(tc).append(' ').append(bfs()).append('\n');
		}
		System.out.println(sb);
	}

	public static int bfs() {

		Queue<int[]> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[201][201][2];

		q.offer(new int[] { x1, y1, 0, 0 });
		visited[x1][y1][0] = true;

		// 수직 이동 시작
		q.offer(new int[] { x1, y1, 1, 0 });
		visited[x1][y1][1] = true;

		while (!q.isEmpty()) {
			int[] info = q.poll();
			int cur_x = info[0];
			int cur_y = info[1];
			int type = info[2];
			int cnt = info[3];
			if (cur_x == x2 && cur_y == y2) {
				return cnt;
			}

			if (type == 0) {
				for (int i = 2; i < 4; i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					if (nx < 0 || nx > 200 || ny < 0 || ny > 200 || visited[nx][ny][1])
						continue;
					q.offer(new int[] { nx, ny, 1, cnt + 1 });
					visited[nx][ny][1] = true;
				}
			} else {
				for (int i = 0; i < 2; i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					if (nx < 0 || nx > 200 || ny < 0 || ny > 200 || visited[nx][ny][0])
						continue;
					q.offer(new int[] { nx, ny, 0, cnt + 1 });
					visited[nx][ny][0] = true;
				}
			}
		}
		return 0;
	}

}
