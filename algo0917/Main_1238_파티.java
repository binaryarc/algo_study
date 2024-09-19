package algo0917;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238_파티 {
	static int N,M,X;
	static ArrayList<int[]>[] vList;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //학생(정점) 수
		M = Integer.parseInt(st.nextToken()); //도로(간선) 개수
		X = Integer.parseInt(st.nextToken()); //시작 에서 도착해서 다시 와야할곳
		
		vList = new ArrayList[N+1];
		for(int i=1;i<=N;i++)vList[i] = new ArrayList<int[]>();
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			vList[from].add(new int[] {to,w});
		}
		
		ans = 0;
		for(int i=1;i<=N;i++) {
			int dist = getMinDist(i,X);
			dist += getMinDist(X,i);
			if(dist > ans)ans = dist;
		}
		
		System.out.println(ans);
		
		
	}
	
	static int getMinDist(int start,int end) {
		int[] minDist = new int[N+1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1,o2)->o1[1]-o2[1]);
		minDist[start] = 0;
		pq.offer(new int[] {start,0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cur_v = cur[0];
			int cur_w = cur[1];
			if(cur_v == end)return cur_w;
			
			for(int[] next : vList[cur_v]) {
				int next_v = next[0];
				int next_w = next[1];
				if(minDist[next_v] > next_w + minDist[cur_v]) {
					minDist[next_v] = next_w + minDist[cur_v];
					pq.offer(new int[] {next_v,minDist[next_v]});
				}
			}
		}
		return -1;
		
	}

}
