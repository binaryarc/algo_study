package algo1116;

import java.io.*;
import java.util.*;

public class Main_2212_센서 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		
		if (K >= N) {
	        System.out.println(0);
	        return;
	    }
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int[] dist = new int[N-1];
		for (int i = 0; i < N - 1; i++) {
			dist[i] = (arr[i + 1] - arr[i]);
		}
		Arrays.sort(dist);
		System.out.println(Arrays.toString(dist));
		int res = 0;
		for (int i = 0; i < N-K; i++) {
			res += dist[i];
		}
		System.out.println(res);
	}
}
