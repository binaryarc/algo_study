package algo1024;

import java.io.*;
import java.util.*;
public class Main_14465_소가길을건너간이유5 {
	static int N,K,B;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //횡단보도 개수
		K = Integer.parseInt(st.nextToken()); //연속해야하는 개수
		B = Integer.parseInt(st.nextToken()); //고장난 개수
		
		int[] arr = new int[N+1];
		for(int i=0;i<B;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			arr[n] = 1;
		}
		
		int cnt = 0;
		for(int i=1;i<=K;i++) {
			cnt += arr[i];
		}
		
		int min = Integer.MAX_VALUE ;
		for(int i=K+1;i<=N;i++) {
			cnt += arr[i] - arr[i-K];
			min = Math.min(min,cnt);
		}
		if(min == Integer.MAX_VALUE) {
			System.out.println(B);
		}else {
			System.out.println(min);
		}
		
	}
}
