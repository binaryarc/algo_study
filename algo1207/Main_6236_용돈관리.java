package algo1207;

import java.io.*;
import java.util.*;

public class Main_6236_용돈관리 {
	static int N, M;
	static int[] arr;
	static int sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int left = Arrays.stream(arr).max().getAsInt();
		int right = Arrays.stream(arr).sum();
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

	public static boolean chk(int k) {
		int cnt = 0;
		int curMoney = 0;
		for (int i = 0; i < N; i++) {
			if(curMoney < arr[i]) {
				cnt++;
				curMoney = k;
			}
			curMoney -= arr[i];
			if(cnt > M)return false;
		}
		return true;
	}
}
