package algo250320;

import java.io.*;
import java.util.*;

public class Main_4803_트리 {
	static int n, m;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}
			if (n == 0 && m == 0)
				break;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			Set<Integer> tree = new HashSet<>();

			for (int i = 1; i <= n; i++) {
				int root_of_i = find(parents[i]);
				if (root_of_i > 0) {
					tree.add(root_of_i);
//					System.out.println(i + "의 부모 : " + find(parents[i]));
				}
			}

//			System.out.println("트리사이즈 : " + tree.size());
			sb.append("Case ").append(tc).append(": ");
			if (tree.size() == 1) {
				sb.append("There is one tree.");
			} else if (tree.size() > 1) {
				sb.append("A forest of ").append(tree.size()).append(" trees.");
			} else {
				sb.append("No trees.");
			}
			sb.append("\n");
			tc++;
		}
		System.out.println(sb);
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int pA = find(a);
		int pB = find(b);

		if (pA == pB) {
			parents[pB] = pA;
			parents[pA] = 0;
			return;
		}
		if(pA < pB)parents[pB] = pA;
		else parents[pA] = pB;
	}
}
