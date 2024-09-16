package algo0911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2623_음악프로그램 {
	static int N,M;
	static ArrayList<Integer>[] list;
	static int[] inDegree;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//가수의 수 즉 정점의수
		N = Integer.parseInt(st.nextToken());
		//입력의수
		M = Integer.parseInt(st.nextToken());
		inDegree = new int[N+1];
		list = new ArrayList[N+1]; //정점의 개수만큼 리스트 생성
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int from = -1;
			int to = -1;
			for(int j=0;j<order;j++) {
				if(from == -1 && to == -1) {
					from = Integer.parseInt(st.nextToken());
				}else if(from != -1 && to == -1 || to == from) {
					to = Integer.parseInt(st.nextToken());
					list[from].add(to);
					from = to;
					inDegree[to]++;
				}
			}
		}
		
		sb= new StringBuilder();
		toplogtSort();
	}
	static void toplogtSort() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			if(inDegree[i]==0) {
				cnt++;
				q.add(i);
				sb.append(i).append('\n');
			}
		}
		while(!q.isEmpty()) {
			int q_size = q.size();
			for(int i=0;i<q_size;i++) {
				int cur = q.poll();
				for(Integer to : list[cur]) {
					if(inDegree[to] == 0)continue;
					else if(--inDegree[to] == 0) {
						q.add(to);
						cnt++;
						sb.append(to).append('\n');
					}
				}
			}
		}
		
		if(cnt == N) {
			System.out.println(sb);
		}else {
			System.out.println(0);
		}
		
		
	}
}