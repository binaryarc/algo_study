package algo1026;

import java.io.*;
import java.util.*;

public class Main_11003_최솟값찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N]; // 입력 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Deque<Integer> dq = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			if (!dq.isEmpty() && dq.peekFirst() < i - L + 1) {
				dq.pollFirst();
			}
			while (!dq.isEmpty() && arr[dq.peekLast()] > arr[i]) {
				dq.pollLast();
			}
			dq.offerLast(i);
			sb.append(arr[dq.peekFirst()]).append(" ");
		}
		// 결과 출력
		System.out.println(sb);
	}
}
