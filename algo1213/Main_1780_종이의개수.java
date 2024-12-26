package algo1213;

import java.io.*;
import java.util.*;

public class Main_1780_종이의개수 {
	static int N;
	static int[][] arr;
	static int minusCnt, zeroCnt, oneCnt;
	static int[][] offsets = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 },
			{ 2, 2 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minusCnt = 0;
		zeroCnt = 0;
		oneCnt = 0;
		solve(0, N - 1, 0, N - 1);
		System.out.println(minusCnt);
		System.out.println(zeroCnt);
		System.out.println(oneCnt);
	}

	public static void solve(int startR, int endR, int startC, int endC) {
		if (isSame(startR, endR, startC, endC)) {
			int kind = arr[startR][startC];
			if (kind == -1)
				minusCnt++;
			else if (kind == 0)
				zeroCnt++;
			else if (kind == 1)
				oneCnt++;
			return;
		}

		int size = (endR - startR + 1) / 3;
		for (int[] offset : offsets) {
			int newStartR = startR + offset[0] * size;
			int newStartC = startC + offset[1] * size;
			solve(newStartR, newStartR + size - 1, newStartC, newStartC + size - 1);
		}
	}

	public static boolean isSame(int startR, int endR, int startC, int endC) {
		int kind = arr[startR][startC];
		for (int i = startR; i <= endR; i++) {
			for (int j = startC; j <= endC; j++) {
				if (arr[i][j] != kind)
					return false;
			}
		}
		return true;
	}

}
