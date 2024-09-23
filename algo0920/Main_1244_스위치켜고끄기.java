package algo0920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {
	static int N,M;
	static int[] lgh;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		lgh = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			lgh[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(s == 1) {
				for(int j = num ; j <= N ;j+= num) {
					lgh[j] ^= 1;
				}
			}else {
				int left = num -1;
				int right = num +1;
				lgh[num] ^= 1;
				while(left >= 1 && right <=N) {
					if(lgh[left] == lgh[right]) {
						lgh[left] ^= 1;
						lgh[right] ^= 1;
					}else {
						break;
					}
					left--;
					right++;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(lgh[i]);
			if (i % 20 == 0 || i == N) {
				System.out.println();
			} else {
				System.out.print(" ");
			}
		}
	}
}
