package algo0908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_9663_NQueen {

	static int N;
	static int[] queens;
	static int ans;
	public static void main(String[] args) throws Exception{
		Scanner sc =  new Scanner(System.in);
		N = sc.nextInt();
		queens = new int[N];
		ans = 0;
		dfs(0,0,0,0);
		System.out.println(ans);
	}
	static void dfs(int r,int left,int mid, int right) {
		if(r == N) {
			ans ++;
			return;
		}
		
		int prevBit = left | mid | right;

		for(int c = 0; c < N ; c++) {
			int curBit = (1<<c);
			if((prevBit & curBit) == 0 ) {
				dfs(r+1,(left|curBit)<<1,mid|curBit,(right|curBit)>>1);
			}
		}
	}
}