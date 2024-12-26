package algo1210;

import java.util.Scanner;

public class Main_20164_홀수홀릭호석 {
	static String N;
	static int min, max;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.next();
		min = Integer.MAX_VALUE;
		max = 0;
		dfs(N, 0);
		System.out.println(min + " " + max);
		sc.close();
	}

	public static void dfs(String num, int cnt) {

		if (num.length() <= 1) {
			if (Integer.parseInt(num) % 2 != 0)
				cnt++;
			max = Math.max(cnt, max);
			min = Math.min(cnt, min);
			return;
		}

		if (num.length() == 2) {
			int tempCnt = cnt;
			for (int i = 0; i < num.length(); i++) {
				if ((num.charAt(i) - '0') % 2 != 0)
					tempCnt++;
			}

			int ten = num.charAt(0) - '0';
			int one = num.charAt(1) - '0';
			String res = Integer.toString((ten + one));
			dfs(res, tempCnt);
			return;
		}

		if (num.length() > 2) {
			int tempCnt = cnt;
			for (int i = 0; i < num.length(); i++) {
				if ((num.charAt(i) - '0') % 2 != 0)
					tempCnt++;
			}

			for (int i = 0; i <= num.length() - 2; i++) {
				for (int j = i + 1; j <= num.length() - 1; j++) {
					String a = num.substring(0, i + 1);
					String b = num.substring(i + 1, j + 1);
					String c = num.substring(j + 1);
					if (a.isEmpty() || b.isEmpty() || c.isEmpty()) continue;
					int res = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c);
					dfs(Integer.toString(res), tempCnt);
				}
			}
		}
	}
}
