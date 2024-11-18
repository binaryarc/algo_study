package algo1108;

import java.io.*;
import java.util.*;

public class Main_18352_특정거리의도시찾기 {
	static int N, M, K, X;
	static List<Integer>[] graph;
	static List<Integer> ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); //최단거리
		X = Integer.parseInt(st.nextToken()); //시작
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		ans = new ArrayList<>();
		bfs(X);
		Collections.sort(ans);
		if(ans.isEmpty())System.out.println(-1);
		else {
			for(int n : ans)System.out.println(n);
		}
	}
	static void bfs(int start) {
		Queue<int[]> q= new ArrayDeque<int[]>();
		q.offer(new int[] {start,0});
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[1] == K) {
				ans.add(cur[0]);
			}
			for(int next : graph[cur[0]]) {
				if(visited[next])continue;
				q.offer(new int[] {next,cur[1]+1});
				visited[next] = true;
			}
		}
		
		
	}
}
