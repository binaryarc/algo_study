package algo1108;

import java.util.*;
import java.io.*;

public class Main_2211_네트워크복구 {
	static int N, M;
	static List<int[]>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] { b, cost });
			graph[b].add(new int[] { a, cost });
		}
		getMinDist(1);
	}

	public static void getMinDist(int start) {
		int[] minDist = new int[N + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[start] = 0;
		Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		Queue<int[]> res = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
		pq.offer(new int[] { start, 0 });
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			for (int next[] : graph[cur[0]]) {
				int nextNode = next[0];
				int nextCost = next[1];
				if (minDist[nextNode] > minDist[cur[0]] + nextCost) {
					minDist[nextNode] = minDist[cur[0]] + nextCost;
					pq.offer(new int[] { nextNode, minDist[nextNode] });
					res.offer(new int[] { cur[0], nextNode, minDist[nextNode] });
				}
			}
		}

		int cnt = 0;
		boolean[] visited = new boolean[N + 1];
		while (!res.isEmpty()) {
			int info[] = res.poll();
			if (visited[info[0]] && visited[info[1]])
				continue;
			if (!visited[info[0]]) {
				cnt++;
				visited[info[0]] = true;
			}
			if (!visited[info[1]]) {
				cnt++;
				visited[info[1]] = true;
			}
			sb.append(info[0]).append(" ").append(info[1]).append("\n");
			if (cnt == N)
				break;
		}
		System.out.println(cnt - 1);
		System.out.println(sb);

	}

}
