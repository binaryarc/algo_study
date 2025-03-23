package algo250320;

import java.beans.Visibility;
import java.io.*;
import java.util.*;

public class Main_20303_할로윈의양아치 {
	// 아이들수, 친구관계의수, 공명하는 수
	static int N, M, K;
	static int[] parents;
	static int[] depth;
	static int[] candy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		candy = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			candy[i] = Integer.parseInt(st.nextToken());
		}
		parents = new int[N + 1];
		depth = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
			depth[i] = 1;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		Map<Integer, int[]> groupMap = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			int root = find(i);
			if(!groupMap.containsKey(root)) {
				groupMap.put(root,new int[] {0,0});
			}
			groupMap.get(root)[0]++;
			groupMap.get(root)[1] += candy[i];
		}
		
		List<int[]> groups = new ArrayList<>(groupMap.values());

		int[] dp = new int[K + 1];
		for (int[] group : groups) {
			int curMember = group[0];
			int curCandy = group[1];
			for (int i = K-1; i >= curMember; i--) {
				dp[i] = Math.max(dp[i], dp[i - curMember] + curCandy);
			}
		}

		System.out.println(dp[K]);
	}

	private static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB) {
			return;
		}

		if(rootA < rootB) {
			parents[rootB] = rootA;
		}else {
			parents[rootA] = rootB;
		}
	}
}
