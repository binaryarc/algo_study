package algo0911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1107_리모컨 {
	static int M;
	static String N;
	static boolean[] btn;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine().trim(); //이동 하려는 채널
		
		if(Integer.parseInt(N) == 100) {
			System.out.println(0);
			return;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //고장난 버튼 개수
		
		if(M == 10) {
			int ans = Math.abs(Integer.parseInt(N) - 100);
			System.out.println(ans);
			return;
		}
		
		btn = new boolean[10]; //고장난 버튼 체크
		if(M > 0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				int n = Integer.parseInt(st.nextToken());
				btn[n] = true;
			}
		}
		
		int ans = Math.abs(100 - Integer.parseInt(N));
		
		for(int  i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			if(isAvail(str)){
				int press = str.length() + Math.abs(i - Integer.parseInt(N));
				ans = Math.min(ans,press);
			}
		}
		System.out.println(ans);
	}
	static boolean isAvail(String str) {
		
		for(int i=0;i<str.length();i++) {
			if(btn[str.charAt(i)-'0']) {
				return false;
			}
		}
		return true;
	}
}