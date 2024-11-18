package algo1112;

import java.io.*;
import java.util.*;

public class Solution_8275_햄스터 {
	static int N, X, M;
	static int l, r, s;
	static List<int[]> history;
	static int[] ans;
	static int tempAns;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 우리 개수
			X = Integer.parseInt(st.nextToken()); // 각 우리에 X마리 이하의 햄스터 존재
			M = Integer.parseInt(st.nextToken()); // 기록 개수
			history = new ArrayList<>();
			ans = new int[N + 1];
			tempAns = -1;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				l = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());
				history.add(new int[] { l, r, s });
			}
			backtracking(1, 0, new int[N + 1]);
			sb.append('#').append(tc).append(' ');
			if(tempAns == -1) {
				sb.append(-1);
			}else {
				for(int i=1;i<=N;i++)sb.append(ans[i]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

	static void backtracking(int cnt, int cur_sum, int[] temp) {
		if (cnt > N) {
			for (int i = 0; i < history.size(); i++) {
				int[] info = history.get(i);
				int sum = 0;
				for (int j = info[0]; j <= info[1]; j++) {
					sum += temp[j];
				}
				if (sum != info[2])
					return;
			}

			if (cur_sum > tempAns) {
				for (int i = 1; i <= N; i++) {
					ans[i] = temp[i];
				}
				tempAns = cur_sum;
			}
			return;
		}

		for (int i = 0; i <= X; i++) {
			temp[cnt] = i;
			backtracking(cnt + 1, cur_sum + i, temp);
		}

	}
}
