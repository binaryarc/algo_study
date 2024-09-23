package algo0923;

import java.io.*;
import java.util.*;

public class Main_16234_인구이동 {
	static int N,L,R;
	static int[][] map;
	static int day;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		day = 0;
		while(bfs()) {
			day++;
		}
		System.out.println(day);
	}
	static boolean bfs() {
		
		boolean[][] visited = new boolean[N][N];
		boolean isMoved = false;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					ArrayList<int[]> list = new ArrayList<int[]>();
					int totalPopul = 0;
					int cnt = 0;
					
					Queue<int[]> q = new ArrayDeque<int[]>();
					q.offer(new int[] {i,j});
					visited[i][j] = true;
					list.add(new int[] {i,j});
					totalPopul += map[i][j];
					cnt++;
					
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						int r = cur[0];
						int c = cur[1];
						
						for(int k=0;k<4;k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if(nr < 0 || nr >= N || nc < 0 || nc >= N)continue;
							if(visited[nr][nc])continue;
							
							int gap = Math.abs(map[r][c] - map[nr][nc]);
							if(gap >= L && gap <= R) {
								q.offer(new int[] {nr,nc});
								visited[nr][nc] = true;
								list.add(new int[] {nr,nc});
								totalPopul += map[nr][nc];
								cnt++;
							}
						}
					}
					if(cnt > 1) {
						int newPopul = totalPopul / cnt;
						for(int[] pos : list) {
							map[pos[0]][pos[1]] = newPopul;
						}
						isMoved = true;
					}
				}
			}
		}
		return isMoved;
	}
}
