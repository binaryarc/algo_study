package algo1211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15661_링크와스타트 {
	static int N;
	static int[][] arr;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		sovle(0, 0);
		System.out.println(ans);
	}

	public static void sovle(int cnt, int teamA) {
		if (cnt == N) {
			
			// teamB 만들기
			// 1로 다채운뒤 teamA not 붙인 비트 and 연산
			int teamB = ((1 << N) - 1) & ~teamA;
			if (teamA == 0 || teamB == 0)
				return; // 팀이 비어있으면 무시
			ans = Math.min(ans, calScore(teamA, teamB));
			return;
		}
		sovle(cnt + 1, teamA);
		sovle(cnt + 1, teamA | (1 << cnt));
	}

	public static int calScore(int teamA, int teamB) {
		int teamAscore = 0;
		int teamBscore = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				// i와 j가 팀 A에 포함된 경우
                if ((teamA & (1 << i)) != 0 && (teamA & (1 << j)) != 0) {
                    teamAscore += arr[i][j] + arr[j][i];
                }
                // i와 j가 팀 B에 포함된 경우
                if ((teamB & (1 << i)) != 0 && (teamB & (1 << j)) != 0) {
                    teamBscore += arr[i][j] + arr[j][i];
                }
			}
		}
		return Math.abs(teamAscore - teamBscore);
	}
}
