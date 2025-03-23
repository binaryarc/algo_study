package algo250311;

import java.util.*;
import java.io.*;

public class Main_24041_성싶당밀키트 {
	static class Food {
		int s, l, o;

		public Food(int s, int l, int o) {
			this.s = s;
			this.l = l;
			this.o = o;
		}
	}

	static class Ans {
		int outCnt;
		long sum;
		int idx;
		int day;

		public Ans(int outCnt, long sum, int idx, int day) {
			this.outCnt = outCnt;
			this.sum = sum;
			this.idx = idx;
			this.day = day;
		}
	}

	static int N, G, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 재료 수
		N = Integer.parseInt(st.nextToken());
		// 허용 가능한 세균 수
		G = Integer.parseInt(st.nextToken());
		// 뺄 수 있는 재료 수
		K = Integer.parseInt(st.nextToken());

		List<Food> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 부패 속도 S
			int S = Integer.parseInt(st.nextToken());
			// 유통기한 L
			int L = Integer.parseInt(st.nextToken());
			// 중요도 O (1이면 뺄 수 있음)
			int O = Integer.parseInt(st.nextToken());
			list.add(new Food(S, L, O));
		}

		int left = 0;
		int right = Integer.MAX_VALUE;
		int ans = 0;
		while(left <= right) {
			int mid = (left+right)/2; // 며칠후까지
			List<Integer> candidate = new ArrayList<>(); // 뺄 후보
			long totalSum = 0;
			for(Food food : list) {
				if(food.l < mid) {
					long temp = (long) food.s * Math.max(1,(mid - food.l));
					if(food.o == 1) {
						candidate.add((int)temp);
					}else {
						totalSum += temp;
					}
				}
			}
			Collections.sort(candidate);
			for(int i=0;i<Math.min(K,candidate.size());i++) {
				totalSum -= candidate.get(i);
			}
			if(totalSum <= G) {
				ans = mid;
				left = mid +1;
			}else {
				right = mid -1;
			}
		}
		System.out.println(ans);

	}
}
