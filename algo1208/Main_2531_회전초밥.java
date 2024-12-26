package algo1208;

import java.io.*;
import java.util.*;

public class Main_2531_회전초밥 {
	static int N, d, k, c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 회전 벨트 초밥 개수
		d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시
		c = Integer.parseInt(st.nextToken()); // 쿠폰번호 c

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] suhsiCount = new int[d + 1]; // 초밥 종류별 개수
		int curUniqueCount = 0; // 현재 윈도우에서 고유 초밥 개수

		for (int i = 0; i < k; i++) {
			if (suhsiCount[arr[i]] == 0) {
				curUniqueCount++;
			}
			suhsiCount[arr[i]]++;
		}

		int maxCount = curUniqueCount;

		for (int start = 0; start < N; start++) {
			int end = (start + k) % N;
			suhsiCount[arr[start]]--; // 첫번째 초밥 제거
			if (suhsiCount[arr[start]] == 0) {
				curUniqueCount--;
			}

			// 윈도우에 새 초밥 추가
			if (suhsiCount[arr[end]] == 0) {
				curUniqueCount++;
			}
			suhsiCount[arr[end]]++;

			// 쿠폰 초밥의 포함 여부 확인
			int tempCount = curUniqueCount;
			if (suhsiCount[c] == 0) {
				tempCount++;
			}

			maxCount = Math.max(maxCount, tempCount);

		}
		System.out.println(maxCount);

	}
}
