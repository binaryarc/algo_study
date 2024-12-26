package algo1211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14391_종이조각_비트마스킹 {
	static int N, M;
	static int[][] arr;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		ans = 0;
		int totalBit = N * M;
		for (int mask = 0; mask < (1 << totalBit); mask++) {
			ans = Math.max(ans, calSum(mask));
		}
		System.out.println(ans);
	}

	public static int calSum(int mask) {
		int sum = 0;

		// 가로 조각
		for (int i = 0; i < N; i++) {
			int cur = 0;
			for (int j = 0; j < M; j++) {
				int idx = i * M + j;
				if ((mask & (1 << idx)) == 0) {
					cur = cur * 10 + arr[i][j];
				} else {
					sum += cur;
					cur = 0;
				}
			}
			sum += cur;
		}
		
		// 세로 조각
		for (int j = 0; j < M; j++) {
			int cur = 0;
			for (int i = 0; i < N; i++) {
				int idx = i * M + j;
				if ((mask & (1 << idx)) != 0) {
					cur = cur * 10 + arr[i][j];
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
