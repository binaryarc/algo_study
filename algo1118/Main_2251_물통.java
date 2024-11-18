package algo1118;

import java.io.*;
import java.util.*;

public class Main_2251_물통 {
	static List<Integer> ans;
	static boolean[][][] visited;
	static int A, B, C;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		visited = new boolean[201][201][201];
		ans = new ArrayList<>();
		dfs(0,0,C);
		Collections.sort(ans);
		for(int n : ans)System.out.print(n+" ");
	}

	static void dfs(int a, int b, int c) {
//		System.out.println(a + " " + b + " "  + c);
		if (!visited[a][b][c]) {
			if(a==0) {
				ans.add(c);
			}
			visited[a][b][c] = true;
			if (a > 0) {
				if (b < B) {
					int tempA = a - (B - b);
					if (tempA <= 0) {
						dfs(0, b + a, c);
					} else {
						dfs(tempA, B, c);
					}
				}

				if (c < C) {
					int tempA = a - (C - c);
					if (tempA <= 0) {
						dfs(0, b, c + a);
					} else {
						dfs(tempA, b, C);
					}
				}
			}
			if (b > 0) {
				if (a < A) {
					int tempB = b - (A - a);
					if (tempB <= 0) {
						dfs(a + b, 0, c);
					} else {
						dfs(A, tempB, c);
					}
				}

				if (c < C) {
					int tempB = b - (C - c);
					if (tempB <= 0) {
						dfs(a, 0, c + b);
					} else {
						dfs(a, tempB, C);
					}
				}
			}
			if (c > 0) {
				if (a < A) {
					int tempC = c - (A - a);
					if (tempC <= 0) {
						dfs(a + c, b, 0);
					} else {
						dfs(A, b, tempC);
					}
				}

				if (c < C) {
					int tempC = c - (B - b);
					if (tempC <= 0) {
						dfs(a, b + c, 0);
					} else {
						dfs(a, B, tempC);
					}
				}
			}
		} else {
			return;
		}
	}
}
