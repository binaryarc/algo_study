package algo1207;

import java.io.*;
import java.util.*;

public class Main_16401_과자나눠주기 {
	static int M, N;
	static long[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		long left = 1; // 최소 길이
        long right = arr[N - 1]; // 최대 길이
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (chk(mid)) {
                ans = mid; // 현재 길이로 나눌 수 있음 -> 정답 후보 저장
                left = mid + 1; // 더 긴 길이 탐색
            } else {
                right = mid - 1; // 더 짧은 길이 탐색
            }
        }
        
		System.out.println(ans);
	}

	public static boolean chk(long mid) {
        int cnt = 0;
        for (long length : arr) {
            cnt += length / mid; // mid 크기로 나눌 수 있는 조각 수
        }
        return cnt >= M;
    }
}
