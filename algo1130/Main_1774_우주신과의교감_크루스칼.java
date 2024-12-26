package algo1130;

import java.io.*;
import java.util.*;

public class Main_1774_우주신과의교감_크루스칼 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Edge {
		int from, to;
		double weight;

		public Edge(int from, int to, double w) {
			this.from = from;
			this.to = to;
			this.weight = w;
		}
	}

	static int N, M;
	static Point[] points;
	static int[] parents;
	static List<Edge> edgeList;

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

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		// 이미 연결된 통로
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		edgeList = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (find(i) != find(j)) {
					edgeList.add(new Edge(i, j, getDist(i, j)));
				}
			}
		}

		edgeList.sort(Comparator.comparingDouble(edge -> edge.weight));
		kruskal();
	}

	public static void kruskal() {
		double total = 0;
		int edgeCount = 0;
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			if (union(edge.from, edge.to)) {
				total += edge.weight;
				edgeCount++;
				if (edgeCount == N - 1)
					break;
			}
		}
		System.out.printf("%.2f", total);
	}

	public static double getDist(int a, int b) {
		double x = Math.pow(points[a].x - points[b].x, 2);
		double y = Math.pow(points[a].y - points[b].y, 2);
		return Math.sqrt(x + y);
	}

	public static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			parents[rootB] = rootA;
			return true;
		}
		return false;
	}

}
