package algo1001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {
	static int n,m;
	static int[][] graph;
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0;
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[start][end] = Math.min(graph[start][end], cost);
		}
		

		for(int th = 1 ; th <= n ; th++) {
			for(int a = 1; a <= n ; a++) {
				for(int b = 1; b <= n ; b++) {
					if(graph[a][th] != INF && graph[th][b] != INF) {
						graph[a][b] = Math.min(graph[a][b], graph[a][th] + graph[th][b]);
					}
				}
			}
		}
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <=n ; j ++) {
				System.out.print(graph[i][j] == INF ? 0 : graph[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
