package algo1009;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003_수들의합2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] sumArr = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i = 1 ; i <= N ; i++) {
			sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int start = 0; // 구간 시작 포인터
		for(int end = 1 ; end <= N ; end++) {
			while(sumArr[end] - sumArr[start] > M) {
				start++; // 구간 합이 M을 넘으면 시작 포인터를 증가시켜 구간을 줄임
			}
			
			if(sumArr[end] - sumArr[start] == M) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

}
