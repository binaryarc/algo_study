package algo0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_25418_정수a를k로만들기 {
	static int A,K;
	static int ans;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 0;
		visited = new boolean[K+1];
				bfs();
		System.out.println(ans);
	}
	static void bfs() {
		Queue<Integer> dq = new ArrayDeque<Integer>();
		dq.offer(A);
		while(!dq.isEmpty()) {
			int q_size = dq.size();
			ans++;
			for(int i = 0 ; i < q_size ; i++) {
				int cur = dq.poll();
				int plus = cur + 1;
				int mul = cur * 2;
				if(plus == K || mul == K)return;

				if(plus <= K && !visited[plus]) {
					dq.offer(plus);
					visited[plus] = true;
				}
				if (mul <= K && !visited[mul]) {
					dq.offer(mul);
					visited[mul] = true;
				}

			}
		}
	}
}
