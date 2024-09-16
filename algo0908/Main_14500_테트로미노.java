package algo0908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N,M;
	static int[][] map;
	static int ans;
	static boolean[][] visited;
	static ArrayList<int[]> tempList;
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
		ans = 0;
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {

				visited[i][j] = true;
				dfs(1, i, j, map[i][j]);
				visited[i][j] = false;
			}
		}
		System.out.println(ans);
	}

	static void dfs(int cnt, int r,int c, int cur_sum) {


		if(cnt == 4) {
			ans = Math.max(ans, cur_sum);
			return;
		}

		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])continue;

			if(cnt==2) {
				visited[nr][nc] = true;
				dfs(cnt + 1 , r , c ,  cur_sum + map[nr][nc]);
				visited[nr][nc] = false;
			}

			visited[nr][nc] = true;
			dfs(cnt + 1 , nr , nc ,  cur_sum + map[nr][nc]);
			visited[nr][nc] = false;
		}

	}



}