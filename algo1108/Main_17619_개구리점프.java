package algo1108;
import java.io.*;
import java.util.*;

public class Main_17619_개구리점프 {
	static class Line implements Comparable<Line>{
		int x1,x2;
		int y;
		int n;
		public Line(int x1,int x2,int y,int n) {
			this.x1 = x1;
			this.x2 = x2;
			this.y = y;
			this.n = n;
		}
		@Override
        public int compareTo(Line o) {
            return Integer.compare(this.x1, o.x1);
        }
	}
	static int N, Q;
	static List<Line> lines;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		lines = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			lines.add(new Line(x1,x2,y,i));
		}
		Collections.sort(lines);
		
		parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
		int max = lines.get(0).x2;
		int group = lines.get(0).n;
		
		for(int i=1;i<N;i++) {
			Line line = lines.get(i);
			if(line.x1 <= max) {
				max = Math.max(max, line.x2);
				union(group, line.n);
			}else {
				group = line.n;
                max = line.x2;
			}
			
			System.out.println(Arrays.toString(parent));
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 =  Integer.parseInt(st.nextToken());
			if (find(n1) == find(n2)) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
		}
		System.out.println(sb);
	}
	public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
	
	public static void union( int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
	
}