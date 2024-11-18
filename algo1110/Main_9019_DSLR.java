package algo1110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019_DSLR {
	static int T,A,B;
	static boolean[] visited;
	static class Status{
		int n;
		String str;
		public Status(int n,String str) {
			this.n = n;
			this.str = str;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			visited = new boolean[100000];
			Queue<Status> q = new ArrayDeque<>();
			q.offer(new Status(A,""));
			
			int res = 0;
			while(!q.isEmpty()) {
				Status cur = q.poll();
				if(cur.n == B) {
					System.out.println(cur.str);
					break;
				}
				
				res = cur.n * 2;
				if(res > 9999)res%=10000;
				
				if(!visited[res]) {
					q.offer(new Status(res, cur.str+'D'));
					visited[res] = true;
				}
				
				res = (cur.n == 0) ? 9999 : cur.n - 1;
				if(!visited[res]) {
				    q.offer(new Status(res, cur.str + 'S'));
				    visited[res] = true;
				}
				
				res = leftShift(cur.n);
				if(!visited[res]) {
					q.offer(new Status(res, cur.str+'L'));
					visited[res] = true;
				}
				
				
				res = rightShift(cur.n);
				if(!visited[res]) {
					q.offer(new Status(res, cur.str+'R'));
					visited[res] = true;
				}
			}
			
		}
	}
	
	public static int leftShift(int number) {
        int firstDigit = number / 1000;
        int remaining = number % 1000; 
        return remaining * 10 + firstDigit; 
    }
	
	public static int rightShift(int number) {
        int lastDigit = number % 10; 
        int remaining = number / 10; 
        return lastDigit * 1000 + remaining;
    }
}
