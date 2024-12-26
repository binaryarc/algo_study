package algo1204;

import java.io.*;
import java.util.*;

public class Main_9370_미확인도착지 {
	static int n, m, t;
	static int s, g, h;
	static List<int[]>[] graph;
	static List<Integer> candidates;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 교차로개수(정점)
			m = Integer.parseInt(st.nextToken()); // 도로개수(간선)
			t = Integer.parseInt(st.nextToken()); // 목적지후보 개수
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken()); // 출발지
			g = Integer.parseInt(st.nextToken()); // 건넌 교차로 g,h
			h = Integer.parseInt(st.nextToken());

			graph = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				graph[a].add(new int[] { b, d });
				graph[b].add(new int[] { a, d });
			}

			candidates = new ArrayList<>();
			for (int i = 0; i < t; i++) {
				candidates.add(Integer.parseInt(br.readLine()));
			}
			Collections.sort(candidates);
			long[] distS = djik(s);
			long[] distG = djik(g);
			long[] distH = djik(h);

			for (int dest : candidates) {
				long directDist = distS[dest];
				long throughGH = distS[g] + distG[h] + distH[dest];
				long throughHG = distS[h] + distH[g] + distG[dest];
				if (directDist == throughGH || directDist == throughHG) {
					sb.append(dest).append(' ');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static long[] djik(int start) {
		Queue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
		long[] dist = new long[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		pq.add(new long[] { start, 0 });

		while (!pq.isEmpty()) {
			long[] cur = pq.poll();
			int curNode = (int) cur[0];
			long curWeight = cur[1];

			if (curWeight > dist[curNode])
				continue;

			for (int[] next : graph[curNode]) {
				int nextNode = next[0];
				long nextWeight = next[1];
				if (curWeight + nextWeight < dist[nextNode]) {
					dist[nextNode] = curWeight + nextWeight;
					pq.add(new long[] { nextNode, dist[nextNode] });
				}
			}
		}
		return dist;
	}
}
