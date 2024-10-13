package algo0925;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {
	static int N, S;
	static List<Integer> list;
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(num);
		}
		dfs(0,0);
		if(S == 0 )ans--;
		System.out.println(ans);
	}
	static void dfs(int cnt,int cur) {
		if(cnt == N) {
			if(cur == S) ans++;
			return;
		}
		dfs(cnt+1,cur+list.get(cnt));
		dfs(cnt+1,cur);
	}
}
