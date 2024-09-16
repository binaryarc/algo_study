package algo0916;

import java.io.*;
import java.util.*;

public class Main_2110_공유기설치 {
	static int N,C;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //집 개수
		C = Integer.parseInt(st.nextToken()); //설치할 공유기 개수
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[N-1] - arr[0];
		
		int result = 0;
		while(left <= right) {
			int mid = (left+right)/2;
			int count = 1;
			
			int lastInstall = arr[0];
			for(int i = 1 ; i < N ; i++) {
				//설정된 거리기준에 만족하면 설치
				if(arr[i] -  lastInstall  >= mid) { 
					count++;
					lastInstall = arr[i];
				}
			}
			
			if(count >= C) {
				//공유기 설치가 더 많이 됐으므로 여유가있으면서 답일 가능성있음
				result = mid;
				left = mid +1; //거리를 늘려봄
			}else {
				//공유기 설치가 덜됨
				right  = mid - 1; //거리를 줄임
			}
		}
		System.out.println(result);
	}
}
