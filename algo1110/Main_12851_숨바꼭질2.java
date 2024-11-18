package algo1110;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12851_숨바꼭질2 {
	static int N, K;
	static int ansTime;
	static int ansCnt;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];

		ansTime = Integer.MAX_VALUE;
		ansCnt = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { N, 0 });
		visited[N] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[0] == K) {
				if (cur[1] < ansTime) {
					ansTime = cur[1];
					ansCnt = 1;
				} else if (cur[1] == ansTime) {
					ansCnt++;
				}
				continue;
			}
			visited[cur[0]] = true;

			int[] nextPos = { cur[0] - 1, cur[0] + 1, cur[0] * 2 };

			for (int next : nextPos) {
				if (isAvailable(next)) {
					q.offer(new int[] { next, cur[1] + 1 });
				}
			}
		}
		System.out.println(ansTime);
		System.out.println(ansCnt);
	}

	static boolean isAvailable(int n) {
		return n <= 100000 && n >= 0 && !visited[n];
	}
}
