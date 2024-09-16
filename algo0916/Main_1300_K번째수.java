package algo0916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1300_K번째수 {
	public static void main(String[] args) throws Exception{
		int N,K;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		//각행은 구구단의 값들임 1단 ~ N단
		
		int result = 0;
		int left = 1;
		int right = K;
		
		while(left <= right) {
			int mid = (left+right)/2;
			
			//B[K] = x 라는 의미는 x 보다 작거나 같은 원소의 개수가 최소 K개
			
			int count = 0; // x보다 작거나 같은 원소의 개수
			for(int i=1;i<=N;i++) {
				count += Math.min(mid / i , N);
			}
			
			if(count >= K) { //현재수(mid)가 B[K]의 숫자보다 크거나 같다는뜻, 여유
				//상한을 낮춘다
				result = mid;
				right = mid -1;
			}else { //현재수(mid)가 B[K]의 숫자보다 작다
				//하한을 높인다
				left = mid + 1;
			}
		}
		
		System.out.println(result);
		
	}

}