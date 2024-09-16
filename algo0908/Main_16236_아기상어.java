package algo0908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main_16236_아기상어 {
	static class Shark{
		int r,c;
		int size;
		int eatCnt;
		public Shark(int r,int c,int size,int eatCnt) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.eatCnt = eatCnt;
		}
	}
	static class Fish implements Comparable<Fish>{
		int r,c;
		int size;
		int dist;
		public Fish(int r,int c,int size,int dist) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish other) {
			// 1. dist가 낮을수록 우선
			if (this.dist != other.dist) {
				return Integer.compare(this.dist, other.dist);
			}
			// 2. r이 낮을수록 우선
			if (this.r != other.r) {
				return Integer.compare(this.r, other.r);
			}
			// 3. c가 낮을수록 우선
			return Integer.compare(this.c, other.c);
		}
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N;
	static int map[][];
	static Shark baby;
	static int time;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0 ; i < N ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					baby = new Shark(i, j, 2,0); 
					map[i][j] = 0;
				}
			}
		}//입력
		time = 0;
		simulation();
		System.out.println(time);
	}
	static void simulation() {
		find();
	}
	static void find() {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new ArrayDeque<int[]>();
		visited[baby.r][baby.c] = true;
		q.offer(new int[] {baby.r,baby.c});

		PriorityQueue<Fish> pq = new PriorityQueue<Fish>();

		int dist = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] cur = q.poll();
				for(int j=0;j<4;j++) {
					int nr = cur[0] + dr[j];
					int nc = cur[1] + dc[j];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N)continue;
					if(visited[nr][nc] || map[nr][nc] > baby.size)continue;
					if(map[nr][nc]!= 0 && map[nr][nc] < baby.size){
						pq.offer(new Fish(nr, nc, map[nr][nc], dist+1));
					}
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc});
				}
			}
			dist++;
			if(!pq.isEmpty()) {
				Fish fish = pq.poll();
				baby.r = fish.r;
				baby.c = fish.c;
				map[fish.r][fish.c] = 0;
				baby.eatCnt++;

				if(baby.eatCnt == baby.size) {
					baby.size++;
					baby.eatCnt = 0;
				}

				time += fish.dist;
				q.clear();
				pq.clear();
				visited = new boolean[N][N];
				visited[baby.r][baby.c] = true;
				dist = 0;
				q.offer(new int[] {baby.r,baby.c});
			}

		}
	}
}