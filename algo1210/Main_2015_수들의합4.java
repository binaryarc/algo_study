package algo1210;

import java.util.*;
import java.io.*;

public class Main_2015_수들의합4 {
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += Integer.parseInt(st.nextToken());
			arr[i] = sum;
		}

		long res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		// 누적합 에서 i ~ j 까지의 합은 sum[j] - sum[i-1]
		// sum[j] - k = sum[i-1]
		for (int j = 1; j <= N; j++) {
			res += map.getOrDefault(arr[j] - K, 0);
			map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
		}
		System.out.println(res);
	}
}
