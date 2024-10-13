package algo1007;

import java.util.*;
import java.io.*;
public class Main_1806_부분합 {
	static int N,S;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = 0;
		int sum = 0;
		int ans = Integer.MAX_VALUE;
		while(right < N) {
			sum += arr[right];
			while(sum >= S) {
				ans = Math.min(ans, right - left + 1);
				sum -= arr[left];
				left++;
			}
			right++;
		}
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(ans);
		}
		
	}
}
