package algo1006;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2613_숫자구슬 {
	static int N,M;
	static int[] arr;
	static int left,right;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		left = 0;
		right = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > left)left = arr[i];
			right += arr[i];
		}
		int sum;
		int groupCnt;
		while(left<=right) {
			int mid = (left+right)/2;
			groupCnt = 1;
			sum = 0;
			for(int i=0;i<N;i++) {
				sum += arr[i];
				if(sum > mid) {
					//현재 구슬 새로운 그룹으로 넘어감
					sum = arr[i];
					groupCnt++;
				}
			}
			
			if(groupCnt > M) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		//정답 출력
		StringBuilder sb = new StringBuilder();
		sb.append(left).append("\n");
		sum = 0;
		int cnt = 0;
		int remainGroups = M;
		for(int i=0;i<N;i++) {
			sum += arr[i];
			if(sum > left) {
				sb.append(cnt).append(" ");
				cnt = 0;
				sum = arr[i];
				remainGroups--;
			}
			cnt++;
			if( N - i == remainGroups)break;
		}
		for(int i=0;i<remainGroups;i++) {
			sb.append(cnt).append(" ");
			cnt = 1;
		}
		
		System.out.println(sb);
	}

}
