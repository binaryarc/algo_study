package algo1021;

import java.io.*;
import java.util.*;

public class Main_2143_두배열의합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long T = Long.parseLong(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr_A = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr_A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int[] arr_B = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr_B[i] = Integer.parseInt(st.nextToken());
		}

		List<Long> sum_A = new ArrayList<Long>();
		List<Long> sum_B = new ArrayList<Long>();

		//A배열 부분배열의 합 저장
		for (int i = 0; i < n; i++) {
			long sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr_A[j];
				sum_A.add(sum);
			}
		}

		//B배열 부분배열의 합 저장
		for (int i = 0; i < m; i++) {
			long sum = 0;
			for (int j = i; j < m; j++) {
				sum += arr_B[j];
				sum_B.add(sum);
			}
		}
		
		Collections.sort(sum_B);
		
		long count = 0 ;
		for(long sumA : sum_A) {
			long target = T - sumA;
			count += countFind(sum_B,target);
		}
		
		
		System.out.println(count);
	}
	
	public static int countFind(List<Long> sum_B, long target) {
		int left = lowerBound(sum_B,target);
		int right = upperBound(sum_B,target);
		
		//등장 횟수
		return right - left;
	}

	//target 이상의 값이 처음으로 나오는 위치
	private static int lowerBound(List<Long> list_b, long target) {
		int left = 0;
		int right = list_b.size();
		
		while(left < right) {
			int mid = (left + right) /2;
			if(list_b.get(mid) < target) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		
		return left;
	}

	//target을 초과하는 값이 처음으로 나오는 위치
	private static int upperBound(List<Long> list_b, long target) {
		int left = 0;
		int right = list_b.size();
		
		while(left < right) {
			int mid = (left + right) /2;
			if(list_b.get(mid) <= target) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		
		return left;
	}
}
