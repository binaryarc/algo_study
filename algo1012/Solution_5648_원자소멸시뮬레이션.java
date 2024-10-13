package algo1012;
import java.io.*;
import java.util.*;
/*
 * 시간 1,373 ms
 * 메모리 150,424 kb
 * 아이디어 : 각 원소 이동후 충돌지점에서 원소들의 에너지량과 충돌지점의 에너지량 확인후
 * 다르면 충돌로 원소 소멸
 * 각칸이 아니라 중간에서 원소들이 만날 수 있기 때문에 원소들의 위치를 * 2
 * 음수제거를 위해 입력위치 +1000
 * 제한범위는 2000 * 2 로 설정 하여 넘어간다면 소멸
 */
public class Solution_5648_원자소멸시뮬레이션 {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Atom {
		int x, y, d, e;

		public Atom(int x, int y, int d, int e) {
			this.x = x * 2;
			this.y = y * 2;
			this.d = d;
			this.e = e;

		}
	}
	

	static List<Atom> atoms;
	static int total_energy;
	static final int BOUNDARY = 4000;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		atoms = new ArrayList<Atom>();
		map = new int[4001][4001];
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			atoms.clear();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				atoms.add(new Atom(x + 1000, y + 1000, d, e));
			}

			total_energy = 0;
			simul();
			sb.append("#").append(tc).append(" ").append(total_energy).append("\n");
			atoms.clear();

		}
		System.out.println(sb);
	}

	private static void simul() {
		while (!atoms.isEmpty()) {
			
			//이동
			for (int i = atoms.size() - 1; i >= 0; i--) {

				Atom atom = atoms.get(i);
				map[atom.y][atom.x] = 0;
				atom.x += dx[atom.d];
				atom.y += dy[atom.d];

				if (atom.x > BOUNDARY || atom.y > BOUNDARY || atom.x < 0 || atom.y < 0) {
					atoms.remove(i);
					continue;
				}

				map[atom.y][atom.x] += atom.e;

			}
			
			//충돌
			for (int i = atoms.size() - 1; i >= 0; i--) {

				Atom atom = atoms.get(i);
				//자신의 에너지와 충돌지점의 에너지가 다르다면 충돌한것임
				if (map[atom.y][atom.x] != atom.e) {
					total_energy += atom.e;
					atoms.remove(i);
					map[atom.y][atom.x] = 0;
				}
			}
		}

	}

}