package algo1207;

import java.io.*;
import java.util.*;

public class Main_1477_휴게소세우기 {
	static int N, M, L;
	static int[] arr;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 현재 휴게소 개수
		M = Integer.parseInt(st.nextToken()); // 더지을 휴게소 개수
		L = Integer.parseInt(st.nextToken()); // 고속도로 길이

		arr = new int[N + 2];
		arr[0] = 0; //도로 시작점
		arr[N + 1] = L; //도로 끝점

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 1;
		int right = L;
		int ans = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (chk(mid)) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}

	// 최대 간격이 len 이하가 되도록 추가 휴게소를 설치할 수 있는지 체크
	public static boolean chk(int len) {
		int cnt = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int gap = (arr[i + 1] - arr[i])-1;
			cnt += gap / len; // 간격안에 몇개의 휴게소가 들어갈 수 있는지
		}
		return cnt <= M; // M개 이하로 휴게소를 설치할 수 있으면 true
	}
}
