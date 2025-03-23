package algo250318;

import java.io.*;
import java.util.*;

public class Main_14217_그래프탐색 {
	static int n, m;
	static List<Integer>[] graph;
	static int tempAns;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int ii = Integer.parseInt(st.nextToken());
			int jj = Integer.parseInt(st.nextToken());
			if (a == 1) {
				graph[ii].add(jj);
				graph[jj].add(ii);
			} else {
				graph[ii].remove(Integer.valueOf(jj));
				graph[jj].remove(Integer.valueOf(ii));
			}
			int[] dist = new int[n + 1];
			Arrays.fill(dist, -1);
			Queue<Integer> queue = new LinkedList<>();
			dist[1] = 0;
			queue.add(1);
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				for (int next : graph[cur]) {
					if (dist[next] == -1) {
						dist[next] = dist[cur] + 1;
						queue.add(next);
					}
				}
			}

			for (int k = 1; k <= n; k++) {
				sb.append(dist[k]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
