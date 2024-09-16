package algo0916;

import java.io.*;
import java.util.*;

public class Main_2470_두용액_이분탐색 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int minSum = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		
		for(int i = 0 ; i < N ; i++) {
			//용액을 하나 선택해서 -용액 에 가까운 용액을 찾음
			int target = -arr[i];
			int idx = binarySerach(i+1, N-1, target);
			
			if(idx < N && Math.abs(arr[i] + arr[idx])< minSum) {
				minSum = Math.abs(arr[i] + arr[idx]);
				left = arr[i];
				right = arr[idx];
			}
			
			//더작은값이 답일수도 있음
			if(idx -1 > i && Math.abs(arr[i] + arr[idx -1]) < minSum) {
				minSum = Math.abs(arr[i] + arr[idx -1]);
				left = arr[i];
				right = arr[idx-1];
			}
		}
		
		System.out.println(left + " " + right);
		
	}
	static int binarySerach(int left, int right, int target) {
		while(left < right) {
			int mid = (left + right)/2;
			
			if(arr[mid] < target) {
				left = mid +1;
			}else {
				right = mid;
			}
		}
		return left;
	}

}
