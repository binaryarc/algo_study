package algo1226;

import java.io.*;
import java.util.*;

public class Main_1719_택배 {
	static int N, M;
	static int[][] dist;
	static int[][] res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dist = new int[N + 1][N + 1];
		res = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], 987654321);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			dist[a][b] = cost;
			dist[b][a] = cost;
			res[a][b] = b;
			res[b][a] = a;

		}

		for (int th = 1; th <= N; th++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dist[i][th] == 987654321 || dist[th][j] == 987654321)
						continue;
					if ((dist[i][th] + dist[th][j]) < dist[i][j]) {
						dist[i][j] = (dist[i][th] + dist[th][j]);
						res[i][j] = res[i][th];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i==j)sb.append('-').append(' ');
				else sb.append(res[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}
}
