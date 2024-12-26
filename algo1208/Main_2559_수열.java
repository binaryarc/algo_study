package algo1208;

import java.io.*;
import java.util.*;

public class Main_2559_수열 {
	static int N, K;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}

		int start = 0;
		int end = K-1;
		int windowSum = sum;
		while (end < N - 1) {
			windowSum = windowSum - arr[start] + arr[end + 1];
			start++;
			end++;
			if (sum < windowSum)
				sum = windowSum;
		}
		System.out.println(sum);
	}

}
