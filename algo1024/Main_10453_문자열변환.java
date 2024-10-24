package algo1024;

import java.util.*;
import java.io.*;

public class Main_10453_문자열변환 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			char[] A = sc.next().toCharArray();
			char[] B = sc.next().toCharArray();
			int L = A.length;
			int LL = B.length;

			if (L != LL) {
				System.out.println(-1);
				continue;
			}
			List<Integer> idx_A_a = new ArrayList<Integer>();
			List<Integer> idx_B_a = new ArrayList<Integer>();
			for (int j = 0; j < L - 1; j++) {
				if (A[j] == 'a')
					idx_A_a.add(j);
				if (B[j] == 'a')
					idx_B_a.add(j);
			}
			int cnt = 0;
			for (int idx = 0; idx < idx_A_a.size(); idx++) {
				cnt += Math.abs(idx_B_a.get(idx) - idx_A_a.get(idx));
			}
			System.out.println(cnt);
		}
	}
}
