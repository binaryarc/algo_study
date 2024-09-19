package algo0918;

import java.io.*;
import java.util.*;

public class Main_1647_도시분할계획 {
	static int N,M;
	static ArrayList<int[]>[] list;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //집(정점) 개수
		M = Integer.parseInt(st.nextToken()); //길(간선) 개수
		
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++)list[i] = new ArrayList<int[]>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to,w});
			list[to].add(new int[] {from,w});
		}
		
		ans = 0;
		prim();
		System.out.println(ans);
	}
	static void prim() {
		
		//선택된 인접정점
		boolean[] visited = new boolean[N+1];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1,o2)-> o1[1] - o2[1]);
		for(ArrayList<int[]> select : list) {
			if(select != null && select.size()>=1) {
				int start = select.get(0)[0];
				pq.offer(new int[] {start,0});
				break;
			}
		}
		
		//마을을 두개 만들기 위해선 mst에서 간선한개를 없애야함
		//간선중 가중치가 큰것을 제거하면 최소비용으로 두개의 마을을 만들 수 있다.
		int max_edge = 0; 
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cur_v = cur[0];
			int cur_w = cur[1];
			
			if(visited[cur_v])continue;
			visited[cur_v] = true;
			ans += cur_w;
			if(cur_w > max_edge) max_edge = cur_w;
			for(int[] next : list[cur_v]) {
				int next_v = next[0];
				int next_w = next[1];
				if(!visited[next_v]) {
					pq.offer(next);
				}
			}
		}
		
		//가장큰 간선 제거
		ans -= max_edge;
	}
}
