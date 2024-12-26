package algo1226;

import java.io.*;
import java.util.*;

public class Main_1854_K번째최단경로찾기 {
	static int n, m, k;
	static List<int[]>[] graph;
	static Queue<Integer>[] maxQ = new PriorityQueue[n + 1];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		
		for(int i=1;i<=n;i++) {
			graph[i] = new ArrayList<int[]>();
		}
		

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] { b, c });
		}
		maxQ = new PriorityQueue[n + 1];
		
		for(int i=1;i<=n;i++) {
			maxQ[i] = new PriorityQueue<>((o1,o2)->o2-o1);
		}

		dijkstra();
		for (int i = 1; i <= n; i++) {
			
			if (maxQ[i].size() != k)
				System.out.println(-1);
			else
				System.out.println(maxQ[i].peek());
		}

	}

	public static void dijkstra() {
		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		maxQ[1].add(0);
		pq.add(new int[] { 1, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cur_node = cur[0];
			int cur_cost = cur[1];

			for (int[] next : graph[cur_node]) {
				int next_node = next[0];
				int next_cost = next[1] + cur_cost;
				
				if (maxQ[next_node].size() < k) {
					maxQ[next_node].add(next_cost);
					pq.add(new int[] { next_node, next_cost });
				} else if (maxQ[next_node].peek() > next_cost) {
					maxQ[next_node].poll();
					maxQ[next_node].add(next_cost);
					pq.add(new int[] { next_node, next_cost });
				}
			}
		}

	}
}
