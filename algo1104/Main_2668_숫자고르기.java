package algo1104;

import java.io.*;
import java.util.*;

public class Main_2668_숫자고르기 {
	static int N;
	static int[] arr;
	static List<Integer> ans_list;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ans_list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(i,i);
			visited[i] = false;
		}
		Collections.sort(ans_list);
		System.out.println(ans_list.size());
		for(int i=0;i<ans_list.size();i++)System.out.println(ans_list.get(i));
	}

	static void dfs(int start, int end ) {
		if(!visited[arr[start]]) {
			visited[arr[start]] = true;
			dfs(arr[start],end);
			visited[arr[start]] = false;
		}
		if(arr[start] == end)ans_list.add(end);
	}

}
