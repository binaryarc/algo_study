package algo0917;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int N;
	static int[][] stats;
	static int[] teamA;
	static int[] teamB;
	static boolean[] isTeamA;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		stats = new int[N][N];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		teamA = new int[N/2];
		teamB = new int[N/2];
		isTeamA = new boolean[N];
		ans = Integer.MAX_VALUE;
		teamAcombi(0,0);
		System.out.println(ans);

	}
	static void teamAcombi(int cnt,int cur_idx) {
		if(cnt == N/2) {
			int teamAsum = 0;
			int teamBsum = 0;
			
			for(int teamA1 : teamA) {
				for(int teamA2 : teamA) {
					if(teamA1 == teamA2)continue;
					teamAsum += stats[teamA1][teamA2];
				}
			}
			
			int idx = 0;
			for(int i=0;i<N;i++) {
				if(isTeamA[i])continue;
				teamB[idx] = i;
				idx++;
			}
			
			for(int teamB1 : teamB) {
				for(int teamB2 : teamB) {
					if(teamB1 == teamB2)continue;
					teamBsum += stats[teamB1][teamB2];
				}
			}
//			System.out.println(teamAsum);
//			System.out.println(teamBsum);
			ans = Math.min(ans,Math.abs(teamAsum - teamBsum));
			return;
			
		}
		for(int i=cur_idx;i<N;i++) {
			if(isTeamA[cur_idx])continue;
			isTeamA[i]=true;
			teamA[cnt] = i;
			teamAcombi(cnt+1,i+1);
			isTeamA[i]=false;
		}
	}
}
