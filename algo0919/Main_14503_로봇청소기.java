package algo0919;
import java.io.*;
import java.util.*;
public class Main_14503_로봇청소기 {
	static int N,M;
	static int[] dr = {-1,0,1, 0};
	static int[] dc = { 0,1,0,-1};
	static int[][] map;
	static int cur_r, cur_c, cur_d;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		cur_r = Integer.parseInt(st.nextToken());
		cur_c = Integer.parseInt(st.nextToken());
		cur_d = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans=0;
		simul();
		System.out.println(ans);
		
	}
	static void simul() {
		while(true) {
			clean();
			if(findBlank()) {
				if(cur_d==0)cur_d = 3;
				else {
					cur_d--;
				}
				int nr = cur_r + dr[cur_d];
				int nc = cur_c + dc[cur_d];
				if(isAvail(nr, nc) && map[nr][nc] == 0) {
					cur_r = nr;
					cur_c = nc;
				}
			}else {
				if(canBack()) {
				}else {
					return;
				}
			}
//			System.out.println(cur_r + " " + cur_c + " " + cur_d);
		}
	}
	static void clean() {
		if(map[cur_r][cur_c] == 0) {
			map[cur_r][cur_c] = -1;
			ans++;
		}
	}
	
	static boolean findBlank() {
		for(int i=0;i<4;i++) {
			int chk_r = cur_r + dr[i];
			int chk_c = cur_c + dc[i];
			if(chk_r < 0 || chk_r >= N || chk_c < 0 || chk_c >= M)continue;
			if(map[chk_r][chk_c] == 0) {
				return true;
			}
		}
		return false;
	}
	
	static boolean isAvail(int r,int c) {
		return (r >= 0 && r < N && c >= 0 && c < M);
	}
	
	static boolean canBack() {
		int nd = cur_d <= 1 ? cur_d + 2 : cur_d - 2;
		int nr = cur_r + dr[nd];
		int nc = cur_c + dc[nd];
		if(isAvail(nr,nc) && map[nr][nc] != 1) {
			cur_r = nr;
			cur_c = nc;
			return true;
		}
		return false;
	}
	
	
}
