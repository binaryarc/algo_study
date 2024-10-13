package algo1007;

import java.io.*;
import java.util.*;

public class Main_1644_소수의연속합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		
		//에라토스테네스의 체로 N까지 소수 구하기
		for(int i=2;i*i<=N;i++) {
			if(isPrime[i]) {
				for(int j=i*i ; j <= N ; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
            	list.add(i);
            }
        }
        
        int S = list.size();
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 0;
        //투포인터로 연속된 소수 합 찾기
        while(right <= S) {
        	if(sum >= N) {
        		sum -= list.get(left++);
        	}else if(right < S) {
        		sum += list.get(right++);
        	}else {
        		break;
        	}
        	
        	if(sum == N) {
        		ans++;
        	}
        }
        System.out.println(ans);
		
		
	}
}
