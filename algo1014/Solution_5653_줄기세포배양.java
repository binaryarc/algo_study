package algo1014;
import java.io.*;
import java.util.*;
/*
 * 실행시간 436 ms
 * 메모리 112,648 kb
 * 우선순위큐를 사용하여 줄기세포정보 저장
 * 줄기세포 활성화시간 계산후 활성화 시
 * 줄기세포 배양 시작
 * 기존 우선순위큐에 계속 추가시 같은 줄기세포가 뽑히기 때문에
 * 새로운 우선순위큐에 임시저장후 기존 우선순위큐에 옮김
 * 
 */
public class Solution_5653_줄기세포배양 {
	static class Cell {
		int r, c, life;
		int acti_time;
		int wait_time;
		boolean isActi;

		public Cell(int r, int c, int life) {
			this.r = r;
			this.c = c;
			this.life = life;
			acti_time = life;
			wait_time = life;
			this.isActi = false;
		}
	}

	static int N, M, K;
	static boolean[][] visited;
	static PriorityQueue<Cell> acti_pq;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); // 배양 시간

			acti_pq = new PriorityQueue<>((o1, o2) -> o2.life - o1.life);
			visited = new boolean[2001][2001];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= M; j++) {
					int n = Integer.parseInt(st.nextToken());
					if (n >= 1) {
						acti_pq.add(new Cell(i + 1000, j + 1000, n));
						visited[i + 1000][j + 1000] = true;
					}
				}
			}

			PriorityQueue<Cell> newPq = new PriorityQueue<>((o1, o2) -> o2.life - o1.life);
			while (K-- > 0) {
				newPq.clear();

				while (!acti_pq.isEmpty()) {
					Cell cell = acti_pq.poll();
					if (!cell.isActi) {
						cell.wait_time--;
						if (cell.wait_time == 0) {
							cell.isActi = true; // 대기 시간이 0이 되면 활성화
						}
						newPq.offer(cell);
					} else if (cell.isActi) {
						for (int d = 0; d < 4; d++) {
							int nr = cell.r + dr[d];
							int nc = cell.c + dc[d];
							if (visited[nr][nc])
								continue;
							visited[nr][nc] = true;
							newPq.offer(new Cell(nr, nc, cell.life));
						}
						cell.acti_time--;
						if (cell.acti_time > 0) {
							newPq.offer(cell);
						}
					}
				}
				acti_pq.addAll(newPq);
			}
			System.out.println("#" + tc + " " + acti_pq.size());
		}
	}

}
