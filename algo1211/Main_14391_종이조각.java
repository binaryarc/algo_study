package algo1211;

import java.util.Scanner;

public class Main_14391_종이조각 {
	static int N, M;
	static int ans;
	static boolean[][] visited;
	static int[][] papers;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		papers = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				papers[i][j] = str.charAt(j) - '0';
			}
		}
		visited = new boolean[N][M];
		ans = 0;
		solve(0);
		System.out.println(ans);
	}

	public static void solve(int idx) {

		if (idx == N * M) {
			ans = Math.max(ans, calSum());
			return;
		}

		int row = idx / M;
		int col = idx % M;

		visited[row][col] = true;
		solve(idx + 1);

		visited[row][col] = false;
		solve(idx + 1);
	}

	public static int calSum() {
		int sum = 0;

		// 가로 계산
		for (int i = 0; i < N; i++) {
			int cur = 0;
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) {
					cur = cur * 10 + papers[i][j];
				} else { //끊기거나 넘어가는 경우
					sum += cur;
					cur = 0;
				}
			}
			sum += cur;
		}

		// 세로 계산
		for (int col = 0; col < M; col++) {
			int cur = 0;
			for (int row = 0; row < N; row++) {
				if (!visited[row][col]) {
					cur = cur * 10 + papers[row][col];
				} else {
					sum += cur;
					cur = 0;
				}
			}
			sum += cur;
		}
		return sum;
	}
}
