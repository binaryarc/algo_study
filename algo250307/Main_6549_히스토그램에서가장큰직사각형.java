package algo250307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6549_히스토그램에서가장큰직사각형 {
	static int[] tree;
	static int[] arr;
	static int n;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			tree = new int[n * 4];
			init(1, 0, n - 1);
			sb.append(getMaxArea(0, n - 1)).append("\n");
		}
		System.out.println(sb);
	}

	private static void init(int node, int start, int end) {
		if (start == end)
			// 인덱스를 저장
			tree[node] = start;
		else {
			int mid = (start + end) / 2;
			init(node * 2, start, mid);
			init(node * 2 + 1, mid + 1, end);

			// 최소값의 인덱스를 저장
			if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]])
				tree[node] = tree[node * 2];
			else
				tree[node] = tree[node * 2 + 1];
		}
	}

	// start, end 현재 노드 범위
	// left, right 가 쿼리 범위
	private static int query(int node, int start, int end, int left, int right) {
		// 범위 밖일때
		if (left > end || right < start)
			return -1;
		// 범위에 포함 될 때
		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;

		// 분할 정복으로 왼쪽과 오른쪽 탐색
		int leftRes = query(node * 2, start, mid, left, right);
		int rightRes = query(node * 2 + 1, mid + 1, end, left, right);

		if (leftRes == -1)
			return rightRes;
		if (rightRes == -1)
			return leftRes;

		// 최소값의 인덱스를 반환
		return (arr[leftRes] <= arr[rightRes]) ? leftRes : rightRes;
	}

	private static long getMaxArea(int start, int end) {
		int minIdx = query(1, 0, n - 1, start, end);
		long area = (long) (end - start + 1) * (long) arr[minIdx];

		// 왼쪽 최대값 탐색
		if (start <= minIdx - 1) {
			area = Math.max(area, getMaxArea(start, minIdx - 1));
		}
		// 오른쪽 최대값 탐색
		if (minIdx + 1 <= end) {
			area = Math.max(area, getMaxArea(minIdx + 1, end));
		}

		return area;
	}
}
