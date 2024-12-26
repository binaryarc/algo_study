package algo1210;

import java.io.*;
import java.util.*;

public class Main_1138_한줄로서기 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		int[] answer = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			int cnt = arr[i];
			for (int j = 1; j <= N; j++) {
				if (answer[j] == 0) {
					if (cnt == 0) {
						answer[j] = i;
						break;
					}
					cnt--;
				}
			}
		}
		for (int n : answer)
			System.out.print(n + " ");
	}
}
