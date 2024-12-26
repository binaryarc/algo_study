package algo1129;

import java.io.*;
import java.util.*;

public class Main_10282_해킹 {
	static int n, d, c;
	static List<int[]>[] graph;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
			d = Integer.parseInt(st.nextToken()); // 의존성 개수, 컴퓨터는 서로에 의존함
			c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터
			graph = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++)
				graph[i] = new ArrayList<>();

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph[b].add(new int[] { a, cost });
			}
			dijkstra(c);
		}
		System.out.println(sb);
	}

	public static void dijkstra(int start) {
		int[] minDist = new int[n + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[start] = 0;

		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		pq.add(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] curInfo = pq.poll();
			int curV = curInfo[0];
			int curCost = curInfo[1];

			if (curCost > minDist[curV])
				continue;

			for (int[] nextInfo : graph[curV]) {
				int nextV = nextInfo[0];
				int nextCost = nextInfo[1];
				int newCost  = curCost + nextCost;

				if (minDist[nextV] > newCost) {
					minDist[nextV] = newCost;
					pq.offer(new int[] { nextV, newCost });
				}
			}
		}

		int count = 0;
		int maxTime  = 0;
		for (int i = 1; i <= n; i++) {
			if (minDist[i] != Integer.MAX_VALUE) {
				count++;
				maxTime  = Math.max(maxTime , minDist[i]);
			}
		}
		sb.append(count).append(' ').append(maxTime).append('\n');
	}
}
