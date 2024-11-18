package algo1117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1092_배 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Integer[] cranes = new Integer[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> boxes = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(cranes, Collections.reverseOrder());
		boxes.sort(Collections.reverseOrder());

		if (boxes.get(0) > cranes[0]) {
			System.out.println(-1);
			return;
		}

		int time = 0;
		while (!boxes.isEmpty()) {
			int boxIdx = 0;

			for (int i = 0; i < N;i++) {
				// 남은 박스 없음
				if (boxIdx >= boxes.size())
					break;

				// 크레인이 가장 무거운 박스부터 옮김
				if (boxes.get(boxIdx) <= cranes[i]) {
					boxes.remove(boxIdx);
					continue;
				} else {
					boxIdx++;
				}
			}
			time++;
		}
		System.out.println(time);
	}
}
