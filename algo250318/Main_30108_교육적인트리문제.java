package algo250318;
import java.io.*;
import java.util.*;
public class Main_30108_교육적인트리문제 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Map<Integer, ArrayList> childs = new HashMap<>();
		int[] values = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 2; i <= N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (!childs.containsKey(parent))
				childs.put(parent, new ArrayList<Integer>());
			childs.get(parent).add(i);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
		Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			return values[o2] - values[o1];
		});
		boolean[] visited = new boolean[N + 1];
		pq.add(1);
		visited[1] = true;
		long sum = 0;
		int cnt = 0;
		while (!pq.isEmpty() && cnt < N) {
			int num = pq.poll();
			cnt++;
			sum += (long)values[num];
			sb.append(sum).append("\n");
			ArrayList<Integer> temp = childs.get(num);
			if(temp != null) {
				for(int next : temp) {
					if(!visited[next]) {
						pq.add(next);
						visited[next] = true;
					}
				}
			}
		}
		System.out.println(sb);
		
	}
}
