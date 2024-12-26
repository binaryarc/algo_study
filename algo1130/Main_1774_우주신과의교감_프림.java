package algo1130;

import java.io.*;
import java.util.*;

public class Main_1774_우주신과의교감_프림 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static Point[] points;
	static List<double[]>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		points = new Point[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new Point(x, y);
		}

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[b].add(new double[] { a, 0 });
			graph[a].add(new double[] { b, 0 });
		}

		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				double dist = getDist(i, j);
				graph[i].add(new double[] { j, dist });
				graph[j].add(new double[] { i, dist });
			}
		}
		prim();
	}

	public static double getDist(int a, int b) {
		double x = Math.pow(points[a].x - points[b].x, 2);
		double y = Math.pow(points[a].y - points[b].y, 2);
		return Math.sqrt((x + y));
	}

	public static void prim() {
		Queue<double[]> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1[1], o2[1]));
		boolean[] visited = new boolean[N + 1];
		double total = 0;

		// 시작노드 삽입
		pq.add(new double[] { 1, 0 });

		while (!pq.isEmpty()) {
			double[] cur = pq.poll();
			int node = (int) cur[0];
			double cost = cur[1];

			if (visited[node])
				continue;

			visited[node] = true;
			total += cost;

			for (double[] next : graph[node]) {
				if (!visited[(int) next[0]]) {
					pq.add(next);
				}
			}
		}
		System.out.printf("%.2f", total);
	}
}
