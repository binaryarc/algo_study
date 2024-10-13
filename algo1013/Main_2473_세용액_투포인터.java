package algo1013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세용액_투포인터 {
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
		long res = Long.MAX_VALUE;
		int[] ans = new int[3];

		for (int i = 0; i < N - 2; i++) {
			int left = i + 1;
			int right = N - 1;
			while (left < right) {
				long sum = (long) arr[i] + (long) arr[left] + (long) arr[right];

				if (Math.abs(sum) < Math.abs(res)) {
					res = sum;
					ans[0] = arr[i];
					ans[1] = arr[left];
					ans[2] = arr[right];
				}

				if (sum > 0) {
					right--;
				} else {
					left++;
				}

			}

		}

		System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
	}
}
