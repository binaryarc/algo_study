package algo1111;

import java.io.*;
import java.util.*;

public class Main_14891_톱니바퀴 {
	static int K;
	static int num, dir;
	static String[] magnet;
	static int[] magnetDir;
	static int L;
	static int left, right;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N극 : 0
		// S극 : 1
		// 12시 방향은 0번 인덱스
		magnet = new String[5];
		for (int i = 1; i <= 4; i++) {
			magnet[i] = br.readLine();
		}
		
		L = 8;
		right = 2;
		left = 6;
		

		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			magnetDir = new int[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken()); // 1 시계방향, -1 반시계방향
			
			magnetDir[num] = dir;
			calDir(num);
			
			for (int j = 1; j <= 4; j++) {
				if (magnetDir[j] == -1) {
					revers(j);
				} else if (magnetDir[j] == 1) {
					rotate(j);
				}
			}
		}
		int sum = 0;
		sum += magnet[1].charAt(0) == '1' ? 1 : 0;
		sum += magnet[2].charAt(0) == '1' ? 2 : 0;
		sum += magnet[3].charAt(0) == '1' ? 4 : 0;
		sum += magnet[4].charAt(0) == '1' ? 8 : 0;
		System.out.println(sum);
		
	}

	public static void rotate(int n) {
		magnet[n] = magnet[n].charAt(L - 1) + magnet[n].substring(0, L - 1);

	}

	public static void revers(int n) {
		magnet[n] = magnet[n].substring(1, L) + magnet[n].charAt(0);
	}

	public static void calDir(int n) {
		
		for (int i = n + 1; i <= 4; i++) {
			if (magnet[i - 1].charAt(right) != magnet[i].charAt(left)) {
				magnetDir[i] = -magnetDir[i - 1];
			} else {
				break;
			}
		}

		for (int i = n - 1; i > 0; i--) {
			if (magnet[i + 1].charAt(left) != magnet[i].charAt(right)) {
				magnetDir[i] = -magnetDir[i + 1];
			} else {
				break;
			}
		}
	}
}
