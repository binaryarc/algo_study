package algo1001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2458_키순서 {
	static int N,M;
	static int[][] graph;
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		
		// 그래프 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    graph[i][j] = INF;  // 초기값 설정
                }
            }
        }
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1; // a가 b보다 키가 작다
		}
		
		//플로이드 와샬 알고리즘으로 도달 가능한곳 표시
		for(int k = 1 ; k <= N ; k++) { //중간 경유지
			for(int i = 1 ; i <= N ; i++) { //시작점
				for(int j = 1; j <= N ; j++) { //도착점
					if(graph[i][k] != INF && graph[k][j] != INF) {
						graph[i][j] = 1;
					}
				}
			}
		}
		int ans = 0;
		for(int i = 1 ; i <= N ; i++) {
			//자신보다 크거나 작은 학생의 수
			int cnt = 0; 
			for(int j = 1 ; j <= N ; j++) {
				if(i != j && (graph[i][j] == 1 || graph[j][i] == 1)) {
					cnt++;
				}
			}
			if(cnt == N-1) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
