package algo1210;

import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Main_2585_경비행기 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class State{
		Point point;
        int cnt;
        public State(Point point, int cnt) {
            this.point = point;
            this.cnt = cnt;
        }
	}

	static int N, K;
	static Point S, T;
	static boolean[] visited;
	static List<Point> points;

	public static void main(String[] args) throws Exception {
		S = new Point(0, 0);
		T = new Point(10000, 10000);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		points = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new Point(x, y));
		}
		points.add(T);
		
		int left = 0;
		int right = (int)Math.sqrt((10000*10000)+(10000*10000));
		int ans = 0;
		
		//이분 탐색으로 연료통 크기 찾기
		while (left <= right) {
			int mid = (left + right) / 2;
			if (bfs(mid)) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}
	public static int getFuel(Point p1, Point p2) {
		// 연료 계산식
		return (int) Math.ceil(
	            Math.sqrt(
	                Math.pow(p1.x - p2.x, 2) + 
	                Math.pow(p1.y - p2.y, 2)
	            ) / 10.0
	        );
	}

	public static boolean bfs(int mid) {
		Queue<State> q = new ArrayDeque<>();
		Set<Point> visited = new HashSet<>();
		
		visited.add(S);
		q.offer(new State(S, 0));
		
		while(!q.isEmpty()) {
			State cur = q.poll();
			if(cur.point.x == T.x && cur.point.y == T.y) {
				return true;
			}
			if(cur.cnt > K)continue;
			
			for(Point next : points) {
				if(!visited.contains(next)) {
					int dist = getFuel(cur.point, next);
					if(dist <= mid) {
						q.offer(new State(next,cur.cnt+1));
						visited.add(next);
					}
				}
			}
		}

		return false;
	}
}
