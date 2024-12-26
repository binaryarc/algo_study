package algo1208;

import java.io.*;
import java.util.*;

public class Main_2096_내려가기 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[] input = new int[3];
		int[] curMax = new int[3];
		int[] curMin = new int[3];
		int[] prevMax = new int[3];
		int[] prevMin = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				input[j] = Integer.parseInt(st.nextToken());
			if (i == 0) {
				curMax = input.clone();
				curMin = input.clone();
				prevMax = input.clone();
				prevMin = input.clone();
			} else {
				curMax[0] = Math.max(prevMax[0], prevMax[1]) + input[0];
				curMax[2] = Math.max(prevMax[1], prevMax[2]) + input[2];
				curMax[1] = Math.max(prevMax[0], prevMax[1]);
				curMax[1] = Math.max(curMax[1], prevMax[2]) + input[1];
				prevMax = curMax.clone();

				curMin[0] = Math.min(prevMin[0], prevMin[1]) + input[0];
				curMin[2] = Math.min(prevMin[1], prevMin[2]) + input[2];
				curMin[1] = Math.min(prevMin[0], prevMin[1]);
				curMin[1] = Math.min(curMin[1], prevMin[2]) + input[1];
				prevMin = curMin.clone();
			}
		}
		int max = Arrays.stream(prevMax).max().getAsInt();
		int min = Arrays.stream(prevMin).min().getAsInt();
		System.out.println(max + " " + min);
	}
}
