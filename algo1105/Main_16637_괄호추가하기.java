package algo1105;

import java.io.*;
import java.util.*;

public class Main_16637_괄호추가하기 {
	static int N;
	static char[] exp;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		exp = br.readLine().toCharArray();
		ans = Long.MIN_VALUE;
		dfs(0, 0);
		System.out.println(ans);
	}

	static void dfs(int idx, long cur_res) {
		if (idx >= N) {
			ans = Math.max(ans, cur_res);
			return;
		}

		char op = (idx == 0) ? '+' : exp[idx - 1];

		// 괄호 넣지 않을때
		dfs(idx + 2, cal(cur_res, cToInt(exp[idx]), op));

		// 괄호 넣을때
		if (idx + 2 < N) {
			long num1 = cToInt(exp[idx]);
			long num2 = cToInt(exp[idx + 2]);
			long cal_res = cal(num1,num2,exp[idx+1]);
			dfs(idx + 4, cal(cur_res, cal_res, op));
		}

	}

	static long cal(long a, long b, char op) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		}
		return 0;
	}

	static int cToInt(char n) {
		return n - '0';
	}
}
