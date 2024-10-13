package algo1001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11403_경로찾기 {
	static int N;
	static int[][] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int n = Integer.parseInt(st.nextToken());
				graph[i][j] = (n==0)?Integer.MAX_VALUE : n;
			}
		}
		
		for(int through = 0; through < N ; through++) {
			for(int a = 0 ; a < N ; a++) {
				for(int b = 0 ; b < N ; b++) {
					if (graph[a][through] != Integer.MAX_VALUE && graph[through][b] != Integer.MAX_VALUE) {
                        graph[a][b] = Math.min(graph[a][b], graph[a][through] + graph[through][b]);
                    }
				}
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0; j < N ; j++) {
				if(graph[i][j] == Integer.MAX_VALUE) {
					System.out.print(0 + " ");
				}else {
					System.out.print(1 + " ");
				}
			}
			System.out.println();
		}
		
	}

}
