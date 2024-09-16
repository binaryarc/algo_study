package algo0916;

import java.io.*;
import java.util.*;

public class Main_2470_두용액_투포인터 {
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
		int right = N - 1;
		int leftNum = 0;
		int rightNum = 0;
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			
			//갱신 될때마다 답일 가능성 있으니 저장
			if(Math.abs(sum) < minSum) {
				minSum = Math.abs(sum);
				leftNum = arr[left];
				rightNum = arr[right];
			}
			
			if(sum > 0) { //0보다 크면 으론쪽값 더 작은값으로
				right--;
			}else if(sum < 0) { //0보다 작으면 왼쪽값 더 큰값으로
				left++;
			}else { // 0일때 중지
				break;
			}
			
		}
		System.out.println(leftNum + " " + rightNum);
		
	}

}
