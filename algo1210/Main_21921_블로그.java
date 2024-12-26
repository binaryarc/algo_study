package algo1210;

import java.io.*;
import java.util.*;

public class Main_21921_블로그 {
	static int N, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 지난 일수
		X = Integer.parseInt(st.nextToken()); // 구할 X일

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int maxCount = 0;
		for (int i = 0; i < X; i++) {
			maxCount += arr[i];
		}

		Map<Integer, Integer> map = new HashMap<>();
		map.put(maxCount, 1);

		int tempCount = maxCount;
		int end = X;
		for (int start = 0; start <= N - X - 1; start++, end++) {
			tempCount -= arr[start];
			tempCount += arr[end];
			if (!map.containsKey(tempCount)) {
				map.put(tempCount, 1);
			} else {
				map.put(tempCount, map.get(tempCount) + 1);
			}
			maxCount = Math.max(maxCount, tempCount);
		}

		if (maxCount == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(maxCount);
			System.out.println(map.get(maxCount));
		}

	}
}
