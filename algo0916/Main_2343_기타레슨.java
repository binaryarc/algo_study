package algo0916;

import java.io.*;
import java.util.*;

public class Main_2343_기타레슨 {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		int right = 0;
		int left = 0;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right += arr[i];
			left = Math.max(left,arr[i]);
		}
		
		int result = right;
		
		while(left <= right) {
			int mid = (left+right)/2;
			
			int count = 1;
			int sum = 0;
			for(int i = 0 ; i < N ; i++) {
				if(sum + arr[i] > mid) {
					count++;
					sum = arr[i];
				}else {
					sum += arr[i];
				}
				
			}
			if(count > M) {
				left = mid +1;
			}else if(count <= M){
				result = mid;
				right = mid - 1;
			}
		}
		
		System.out.println(result);
		
		
		
		
	}

}