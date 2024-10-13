package algo1013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세용액_이분탐색 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int[] ans = new int[3];
		long res = Long.MAX_VALUE;  // 0에 가장 가까운 값을 찾기 위한 변수
		
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				long target = -(long) (arr[i] + arr[j]);
				int left = j + 1;
				int right = N - 1;
				int ans_idx = -1; // 이분 탐색 결과 저장용 변수
				long mid_diff = Long.MAX_VALUE;
				
				while (left <= right) {
					int mid = (left + right) / 2;
					long diff = Math.abs(arr[mid] - target);
					
					if(diff < mid_diff) {
						mid_diff = diff;
						ans_idx = mid;
					}
					
					if(arr[mid] < target) {
						left = mid + 1;
					}else if(arr[mid] > target){
						right = mid - 1;
					}else { //0이 떨어지면
						ans_idx = mid;
						break;
					}
					
				}
				
				long sum = (long) arr[i] + (long) arr[j] + (long) arr[ans_idx];
				if(Math.abs(sum) < Math.abs(res)) {
					res = sum;
                    ans[0] = arr[i];
                    ans[1] = arr[j];
                    ans[2] = arr[ans_idx];
				}

			}
		}

		System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
	}
}
