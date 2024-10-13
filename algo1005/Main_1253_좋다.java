package algo1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1253_좋다 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int ans = 0;
		for(int i = N -1 ; i >= 0 ; i--) {
			int target_num = arr[i];
			boolean find = false;
			for(int j = N - 1 ; j >= 0 ; j--) {
				if(i == j)continue; //target 자신과 다른수만 이용
				int left = 0;
				int right = j - 1;
				
				while(left <= right) {
					int mid = (left + right)/2;
					int num1 = arr[j];
					int num2 = target_num - num1;
					if(arr[mid] > num2) {
						right = mid - 1;
					}else if(arr[mid] == num2 && mid != i && mid != j) {
						find = true;
						break;
					}else {
						left = mid + 1;
					}
				}
			}
			if(find)ans++;
		}
		
		System.out.println(ans);
	}

}
