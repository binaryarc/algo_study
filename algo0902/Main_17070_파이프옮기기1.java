package algo0902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	static class Pipe{
		int r,c;
		public Pipe() {
			
		}
	}
	static int N;
	static int[][] map;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans=0;
		dfs(1,0,1); //state 1 : 가로, 2 : 대각, 3 : 세로
		System.out.println(ans);
	}
	
	static void dfs(int cur_state,int cur_r, int cur_c) {
		if(cur_r >= N || cur_c >= N)return;
		if(map[cur_r][cur_c] == 1) return;
		if(cur_state == 2) {
			//대각선일때 왼쪽, 위 체크
			if(map[cur_r-1][cur_c] == 1 
					|| map[cur_r][cur_c-1]== 1)return;
		}
		
		
		//N-1 행 N-1 열이면 cnt ++;
		if(cur_r == N-1 && cur_c == N-1) {
			ans++;
		}
		
		if(cur_state == 1) { //가로
			dfs(cur_state,cur_r,cur_c+1); //가로
			dfs(cur_state+1,cur_r+1,cur_c+1); //대각
		}else if(cur_state == 2) { //대각
			dfs(cur_state - 1 ,cur_r,cur_c+1); // 가로
			dfs(cur_state,cur_r+1,cur_c+1); //대각
			dfs(cur_state+1,cur_r+1,cur_c); //세로
		}else { //세로
			dfs(cur_state,cur_r+1,cur_c); // 세로
			dfs(cur_state-1,cur_r+1,cur_c+1); //대각
		}
		
	}
}