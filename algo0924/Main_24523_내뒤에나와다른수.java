package algo0924;

import java.io.*;
import java.util.*;

public class Main_24523_내뒤에나와다른수 {
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		int[] ans = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		//마지막은 무조건 -1
		ans[N] = -1;
		for(int i = N - 1 ; i >= 1 ; i--) {
			if(arr[i] == arr[i+1]) {
				ans[i] = ans[i+1];
			}
			else {
				ans[i] = i + 1;
			}
		}
		
		for(int i=1;i<=N;i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
		
		
	}

}
