package algo1117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 축제 참가자들은 하루에 맥주 1명 마시기 가능
 * 이전에 받았던 종류의 맥주는 다시 받지못함
 * 총N일 동안 N병을 마실수있다
 * 마시는 맥주 N개의 선호도의 합이 M 이상이 되어야함
 * 가능한 도수를 낮게 마셔야함
 */

public class Main_17503_맥주축제 {
	static class Beer {
		int v;
		int c;

		public Beer(int v, int c) {
			this.v = v; // 선호도
			this.c = c; // 도수레벨
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Beer> beers = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			beers.add(new Beer(v, c));
		}

		beers.sort((o1, o2) -> {
			if (o1.c == o2.c) {
				return o2.v - o1.v;
			}
			return o1.c - o2.c;
		});

		int resV = 0;
		long result = -1;
		Queue<Integer> pq = new PriorityQueue<>();

		for (Beer beer : beers) {
			resV += beer.v;
			pq.add(beer.v);

			if (pq.size() > N) {
				resV -= pq.poll();
			}

			if (pq.size() == N && resV >= M) {
				result = beer.c;
				break;
			}
		}

		System.out.println(result);
	}
}
