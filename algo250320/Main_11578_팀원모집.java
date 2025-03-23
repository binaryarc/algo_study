package algo250320;

import java.io.*;
import java.util.*;

public class Main_11578_팀원모집 {
	static int N, M;
	static List<Integer>[] students;
	static int ans;
	static int allMask;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		allMask = (1<<N)-1;
		M = Integer.parseInt(st.nextToken());
		students = new ArrayList[M];
		for (int i = 0; i < M; i++)
			students[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				students[i].add(Integer.parseInt(st.nextToken())-1);
			}
		}
		ans = Integer.MAX_VALUE;
		dfs(0, 0, 0);
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static void dfs(int idx, int mask, int cnt) {
		if(mask == allMask) {
			ans = Math.min(ans,cnt);
			return;
		}
		
		if(idx == M)return;
		
		dfs(idx + 1, mask, cnt);
		int newMask = mask;
		for (int i : students[idx]) {
			newMask |= (1 << i);
		}
		dfs(idx + 1, newMask, cnt + 1);

	}
}
