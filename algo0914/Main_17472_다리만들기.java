package algo0914;

import java.io.*;
import java.util.*;

public class Main_17472_다리만들기 {
	static int N,M;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] visited;
	static ArrayList<int[]>[] list;
	static int[] minDist;
	static boolean[] vis;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int cnt = 0;
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					bfs(i,j,cnt);
				}
			}
		}
		visited = new boolean[N][M];
		list = new ArrayList[7];
		for(int i=1;i<=6;i++) {
			list[i] = new ArrayList<int[]>();
			
		}
		
		for(int i=1;i<=cnt;i++) {
			find(i);
		}
		
		int ans = getMinDist(cnt);
		System.out.println(ans);
		
	}
	static int getMinDist(int cnt) {
		minDist = new int[cnt+1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		vis = new boolean[cnt+1];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1,o2)->o1[1]-o2[1]);
		int totalDist = 0;
		int tempCnt = 0; //처리한 정점수
		
		minDist[1] = 0;
		pq.add(new int[] {1,0});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curNode = cur[0];
			int curDist = cur[1];
			
			if(vis[curNode])continue;
			
			vis[curNode]= true;
			totalDist += curDist;
			if (++tempCnt == cnt) return totalDist;  // 모든 섬을 연결한 경우

			
			for(int[] next : list[curNode]) {
				int nextNode = next[0];
				int nextDist = next[1];
				if(vis[nextNode])continue;
				if(minDist[nextNode] <= nextDist || nextDist == 1)continue;
				minDist[nextNode] = nextDist;
				pq.offer(new int[] {nextNode, nextDist});
			}
		}
		
		return -1;

	}
	
	static void find(int start) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == start) {
					for(int d=0;d<4;d++) {
						int dist = 0;
						int nr = i;
						int nc = j;
						while(true) {
							dist++;
							nr = nr + dr[d];
							nc = nc + dc[d];
							if(nr < 0 || nr >= N || nc < 0 || nc >= M)break;
							if(map[nr][nc] == start ) break;
							if(map[nr][nc] >= 1) {
								if(dist - 1 >= 2) {
									list[start].add(new int[] {map[nr][nc],dist - 1});
								}
								break;
							}
						}
					}
				}
			}
		}
	}
	
	static void bfs(int r,int c,int n) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		visited[r][c] = true;
		map[r][c] = n; 
		q.offer(new int[] {r,c});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i=0;i<4;i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])continue;
				if(map[nr][nc] == 0)continue;
				map[nr][nc] = n;
				visited[nr][nc] = true;
				q.offer(new int[] {nr,nc});
			}
		}
	}
}