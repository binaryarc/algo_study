package algo250217;

import java.io.*;
import java.util.*;

public class Main_2580_스도쿠 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[][] grid;
	static List<Point> target;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		grid = new int[9][9];
		target = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int n = Integer.parseInt(st.nextToken());
				grid[i][j] = n;
				if (n == 0) {
					target.add(new Point(i, j));
				}
			}
		}
		
		solve(0);

	}

	public static void solve(int idx) {

		if (idx == target.size()) {
			printGrid();
			System.exit(0);
		}

		Point p = target.get(idx);

		for (int n = 1; n <= 9; n++) {
			if (chk(p.r, p.c, n)) {
				grid[p.r][p.c] = n;
				solve(idx+1);
				grid[p.r][p.c] = 0;
			}
		}
	}

	public static boolean chk(int r, int c, int num) {
		for (int i = 0; i < 9; i++) {
			if (grid[r][i] == num || grid[i][c] == num)
				return false;
		}
		int sr = (r / 3) * 3;
		int sc = (c / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[sr + i][sc + j] == num)
					return false;
			}
		}
		return true;
	}

	public static void printGrid() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
