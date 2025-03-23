package algo250311;

import java.io.*;
import java.util.*;

public class Main_25393_교집합만들기 {
	static int N, Q;
	static Map<Integer,TreeSet<Integer>> leftMap;
	static Map<Integer,TreeSet<Integer>> rightMap;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		leftMap = new HashMap<>();
		rightMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if(!leftMap.containsKey(l)) {
				leftMap.put(l, new TreeSet<Integer>());
			}
			leftMap.get(l).add(r);
			if(!rightMap.containsKey(r)) {
				rightMap.put(r, new TreeSet<Integer>());
			}
			rightMap.get(r).add(l);
		}

		Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			sb.append(solve(l,r));
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static int solve(int l,int r) {
		
		// 정확한 교집합 만들지 못함
		if(!leftMap.containsKey(l) || !rightMap.containsKey(r)) {
			return -1;
		}
		if(leftMap.get(l).ceiling(r)==null)return -1;
		if(rightMap.get(r).floor(l)==null)return -1;
		if(leftMap.get(l).ceiling(r) == r)return 1;
		if(rightMap.get(r).floor(l) != null) return 2;
		return -1;
	}
}
