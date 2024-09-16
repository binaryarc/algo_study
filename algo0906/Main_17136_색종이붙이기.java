package algo0906;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기 {
	static class Point{
		int r,c;
		public Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
	static boolean[][] visited;
	static int[][] map;
	static ArrayList<Point> oneList;
	static int L;
	static int ans;
	static int[] use_size;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[10][10];
		oneList = new ArrayList<Point>();
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					oneList.add(new Point(i, j));
				}
			}
		}
		visited = new boolean[10][10];
		L = oneList.size();
		use_size = new int[]{0,5,5,5,5,5};
		ans = Integer.MAX_VALUE;
		dfs(0,0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	static void dfs(int cnt,int cur_cnt) {
		
		if(cnt == L) {
			ans = Math.min(ans,cur_cnt);
			return;
		}
		
		Point cur = oneList.get(cnt);
		
		
		if(visited[cur.r][cur.c]) {
			dfs(cnt+1,cur_cnt);
			return;
		}
		
		for(int i=1;i<=5;i++) {
			if(use_size[i] <= 0 || !canAttach(cur.r, cur.c, i))continue;
			
			for(int k = cur.r ; k < cur.r + i ; k++) {
				for(int t = cur.c ; t < cur.c + i; t++) {
					visited[k][t] = true;
				}
			}
			
			use_size[i]--;
			dfs(cnt+1,cur_cnt+1);
			use_size[i]++;
			
			
			for(int k = cur.r ; k < cur.r + i ; k++) {
				for(int t = cur.c ; t < cur.c + i; t++) {
					visited[k][t] = false;
				}
			}
		}
	}
	
	static boolean canAttach(int r,int c, int size) {
		if (r + size > 10 || c + size > 10) return false;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] == 0 || visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
	}
	
	
}