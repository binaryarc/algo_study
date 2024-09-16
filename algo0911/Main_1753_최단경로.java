package algo0911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
	static int V,E;
	static int start;
	static ArrayList<int[]>[] list;
	static boolean[] visited;
	static int[] minDist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		list = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			list[i] = new ArrayList<int[]>();
		}

		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to,w});
		}
		visited = new boolean[V+1];
		minDist = new int[V+1];
		for(int i=0;i<=V;i++) {
			minDist[i] = Integer.MAX_VALUE;
		}
		minDist[start] = 0;
		getMinDist();
		for(int i=1;i<=V;i++) {
			int dist = minDist[i];
			if(dist == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(dist);
			}
		}
	}
	static void getMinDist() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
		pq.add(new int[] {start,0});
		while(!pq.isEmpty()) {
			
			int[] cur = pq.poll();
			int curNode = cur[0];
			int curDist = cur[1];
			
			if(visited[curNode])continue;
			visited[curNode]= true;
			
			for(int[] adjNode : list[curNode]) {
				int nextNode = adjNode[0];
				int nextWeight = adjNode[1];
				if(minDist[nextNode] > curDist + nextWeight) {
					minDist[nextNode] = curDist + nextWeight;
					pq.add(new int[] {nextNode, minDist[nextNode]});
				}
			}
		}
	}

}