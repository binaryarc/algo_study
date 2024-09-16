package algo0907;
/*
 * 조건 : 
 * 1. 두구역을 선정해야한다
 * 2. 각 구역은 두 선거구중 하나에 포함 되어야 한다
 * -> 두선거구가 연결되어 있어도 상관 없지만
 * 선거구끼리는 서로 연결 되어있어야한다.
 * 두선거구와 연결이 안된 구역이 있으면 안된다.
 * = 모든구역 연결됨
 * 
 * 해결 
 * 선거구역들 선정
 * 완전탐색?
 * 모든 조합을 찾고 그조합이 조건에 만족하는지 확인
 * 
 * 연결되어 있는지 확인
 * 
 * 두구역간의 인구 차이수를 최소화
 * 완전탐색
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
	static int N;
	static ArrayList<Integer>[] graph;
	static int[] popul;
	static ArrayList<Integer> selectArea;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		popul = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for(int from=1;from<=N;from++) {
			st = new StringTokenizer(br.readLine());
			int areaCnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < areaCnt ; j ++) {
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
				graph[to].add(from);
			}
		}

		ans = Integer.MAX_VALUE;
		for(int i = 1 ; i <= N/2 ; i++) {
			combi(0,1,i,new int[i]);
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}
	static void combi(int cnt,int start,int L,int[] arrA) {
		if(cnt == L) {
			boolean[] selected = new boolean[N+1];
			for(int num : arrA) {
				selected[num] = true;
			}
			
			int[] arrB = new int[N-L];
			int idx=0;
			
			for(int num = 1 ; num <= N ; num++) {
				if(selected[num])continue;
				arrB[idx] = num;
				idx++;
			}
			
			
			if(isConnected(arrA) && isConnected(arrB)) {
				int totalA = 0;
				int totalB = 0;
				for(int num : arrA)totalA += popul[num];
				for(int num : arrB)totalB += popul[num];
				ans = Math.min(ans, (Math.abs(totalA - totalB)));
			}
			

			return;

		}

		for(int i=start;i<=N;i++) {
			arrA[cnt] = i;
			combi(cnt+1,i+1,L,arrA);
		}
	}
	
	static boolean isConnected(int[] arr) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(arr[0]);
		visited[arr[0]] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : graph[cur]) {
				if(!visited[next] && containArr(arr,next)) {
					visited[next] = true;
					q.add(next);
					cnt++;
				}
			}
		}
		return cnt == arr.length;
	}
	static boolean containArr(int[] arr, int num) {
		for(int arrNum : arr) {
			if(num == arrNum)return true;
		}
		return false;
	}

}