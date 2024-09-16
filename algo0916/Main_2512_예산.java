package algo0916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2512_예산 {
	static int N;
	static int[] arr;
	static int totalAmount;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		totalAmount = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = Math.min(arr[N-1],totalAmount);
		int result = 0;
		while(left <= right) {
			int mid = (left + right)/2;
			int sum = 0;
			int cnt = 0;
			
			for(int i=0;i<N;i++) {
				if(arr[i] > mid ) {
					sum += mid;
				}else {
					sum += arr[i];
				}
			}
			if(sum <= totalAmount) {
				result = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
			
		}
		System.out.println(result);
		
		
	}
}