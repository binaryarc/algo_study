package algo1024;

import java.util.*;
import java.io.*;

public class Main_9470_Strahler순서 {
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken()); // 테케번호
			int M = Integer.parseInt(st.nextToken()); // 노드수
			int P = Integer.parseInt(st.nextToken()); // 간선수
			list = new ArrayList[M + 1];
			for (int i = 1; i <= M; i++) {
				list[i] = new ArrayList<Integer>();
			}

			int[] inDegree = new int[M + 1];

			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list[start].add(end);
				inDegree[end]++;
			}

			int[] order = new int[M + 1];
			int[] count = new int[M + 1];
			Queue<Integer> q = new ArrayDeque<Integer>();
			for (int i = 1; i <= M; i++) {
				if (inDegree[i] == 0) {
					q.add(i);
					order[i] = 1;
				}
			}

			int cnt = 0;

			while (!q.isEmpty()) {
				int cur = q.poll();
				if (cnt == M)
					break;
				for (int next : list[cur]) {
					
					if(order[next] < order[cur] ) {
						order[next] = order[cur];
						count[next]=1;
					}else if(order[next] == order[cur]) {
						count[next]++;
					}
					inDegree[next]--;
					
					if (inDegree[next] == 0) {
						if(count[next] >= 2) {
							order[next]++;
						}
						q.add(next);
					}
				}
			}
			System.out.println(K + " " + order[M]);

		}
	}
}
