package algo1026;

import java.io.*;
import java.util.*;

public class Main_2776_암기왕 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int[] arr2 = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for (int i = 0; i < M; i++) {
				int target = arr2[i];
				int left = 0;
				int right = N - 1;

				int res = 0;
				while (left <= right) {
					int mid = (left + right) / 2;
					if (arr[mid] <= target) {
						left = mid + 1;
						res = arr[mid];
					} else {
						right = mid - 1;
					}
				}
				if(res == target)sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}

}
