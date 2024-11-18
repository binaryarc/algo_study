package algo1111;

import java.io.*;
import java.util.*;

public class Main_2146_다리만들기 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<int[]>[] list;
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
        
        
        visited = new boolean[N][N];
        int num = 1;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j,num);
                    num++;
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j] > 0) {
                	ans = Math.min(ans,bfs2(i,j,map[i][j]));
                }
            }
        }
        System.out.println(ans);
        
        
    }
    
    static int bfs2(int r,int c,int number) {
    	boolean[][] visited = new boolean[N][N];
    	Queue<int[]> q = new ArrayDeque<>();
    	q.offer(new int[] {r,c,0});
    	visited[r][c] = true;
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		
    		for(int i=0;i<4;i++) {
    			int nr = cur[0] + dr[i];
    			int nc = cur[1] + dc[i];
    			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])continue;
    			
    			if(map[nr][nc] > 0 && map[nr][nc] != number) {
    				return cur[2];
    			}
    			
    			if(map[nr][nc] == 0) {
    				q.offer(new int[] {nr,nc,cur[2]+1});
    				visited[nr][nc] = true;
    			}
    		}
    	}
    	return Integer.MAX_VALUE;
    }
    
    
    static void bfs(int r,int c,int number) {
        Queue<int[]> q = new ArrayDeque<int[]>();
        visited[r][c] = true;
        q.offer(new int[] {r,c});
        map[r][c] = number;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int i=0;i<4;i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])continue;
                if(map[nr][nc] == 0 ) continue;
                map[nr][nc] = number;
                q.offer(new int[] {nr,nc});
                visited[nr][nc] = true;
            }
        }
    }
}
