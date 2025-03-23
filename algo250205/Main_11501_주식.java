package algo250205;

import java.io.*;
import java.util.*;

public class Main_11501_주식 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			long maxRes = 0;
			long curMax = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] > curMax) {
					curMax = arr[i];
				} else {
					maxRes += (curMax - arr[i]);
				}
			}

			System.out.println(maxRes);
		}
	}
}
