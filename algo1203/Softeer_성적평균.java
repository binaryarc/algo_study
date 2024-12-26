package algo1203;

import java.io.*;
import java.util.*;

public class Softeer_성적평균 {
	static int N, K;
	static int[] scores;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		scores = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int sum = 0;
			for (int j = start; j <= end; j++) {
				sum += scores[j-1];
			}
			double res = (double)sum / (double)((end - start)+1.0);
			sb.append(String.format("%.2f", res)).append('\n');
		}
		System.out.println(sb);
	}
}
