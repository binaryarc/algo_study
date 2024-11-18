package algo1110;

import java.io.*;
import java.lang.invoke.VolatileCallSite;
import java.util.*;

public class Main_11559_뿌요뿌요 {
	static char[][] map;
	static boolean flag;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}

		ans = 0;
		while (true) {
			flag = false;
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						bfs(i, j);
					}
				}
			}
			
			if (flag) {
				ans++;
				gravity();
			} else {
				break;
			}
		}
		System.out.println(ans);
	}

	public static void bfs(int r, int c) {

		boolean[][] visited = new boolean[12][6];
		List<int[]> clearList = new ArrayList<>();
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { r, c });
		visited[r][c] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			clearList.add(new int[] {cur[0],cur[1]});
			cnt++;
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6)
					continue;
				if (visited[nr][nc])
					continue;
				if (map[nr][nc] == map[cur[0]][cur[1]]) {
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
			}
		}

		if (cnt >= 4) {
			flag = true;
			for(int[] pos : clearList) {
				map[pos[0]][pos[1]] = '.';
			}
			
		}
	}
	
	public static void gravity() {
		for (int j = 0; j < 6; j++) {
            int curBottom = 11;
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] != '.') {
                    map[curBottom][j] = map[i][j];
                    if (curBottom != i) map[i][j] = '.';
                    curBottom--;
                }
            }
        }
	}
}
