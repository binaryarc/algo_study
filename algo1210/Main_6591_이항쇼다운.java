package algo1210;

import java.util.*;
import java.io.*;

public class Main_6591_이항쇼다운 {
	static int n, k;
//	static int[][] memo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//nCr == n-1Cr-1 + n-1Cr
		//nCr == nCn-r
		//nCr == nPr / r!
		
//		memo = new int[10001][10001];
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			if (n == 0 && k == 0)
				break;
			long ans = 1;
			
			if(k > n/2) {
				k = n-k;
			}
			
			for(int i=1;i<=k;i++) {
				ans *= n;
				ans /= i;
				n--;
			}
			System.out.println(ans);
		}
	}

//	public static int combi(int n, int k) {
//		if (n == k || k == 0) {
//			return 1;
//		}else if(n <=10000 && k <=10000){
//			if(memo[n-1][k-1] == 0 && memo[n-1][k]==0) {
//				memo[n-1][k-1] = combi(n-1,k-1);
//				memo[n-1][k] = combi(n-1, k);
//				
//			}else if(memo[n-1][k-1] != 0 && memo[n-1][k]==0) {
//				memo[n-1][k] = combi(n-1, k);
//			}else if(memo[n-1][k-1] == 0 && memo[n-1][k]!=0) {
//				memo[n-1][k-1] = combi(n-1,k-1);
//			}
//			return memo[n-1][k-1] + memo[n-1][k];
//		}else {
//			return combi(n-1,k-1) + combi(n-1, k);
//		}
//	}
}
