package algo1012;

import java.io.*;
import java.util.*;


/*
 * 아이디어 : 원자들이 동시에 이동 했을때의 상태들을 Map안의 리스트에 저장하여
 * 리스트 사이즈가 2이상일때 충돌하여 방출한 에너지 저장
 * 주의할점 : 원자들이 같은칸에 모일때만 고려하는것이 아니라
 * 각 칸의 중간지점에서 만났을때도 고려해야함
 * 원자 클래스 생성시 x,y 좌표를 2배로 설정하여 
 * 짝수 이동마다 중간지점 충돌 처리
 */

public class Solution_5648_원자소멸시뮬레이션2 {
	static class Atom {
		int x, y, dir, energy;
		boolean isRemoved;

		public Atom(int x, int y, int d, int e) {
			this.x = x * 2;
			this.y = y * 2;
			this.dir = d;
			this.energy = e;
		}
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static List<Atom> atoms;
	static int totalEnergy;
	static final int BOUNDARY = 4000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			atoms = new ArrayList<>();
			totalEnergy = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				atoms.add(new Atom(x, y, d, e));
			}

			simul();
			System.out.println("#" + tc + " " + totalEnergy);
		}
	}

	private static void simul() {
		while (!atoms.isEmpty()) {
			Map<String, List<Atom>> positions = new HashMap<>();

			for (Atom atom : atoms) {
				if (atom.isRemoved)
					continue;

				int nx = atom.x + dx[atom.dir];
				int ny = atom.y + dy[atom.dir];

				if (Math.abs(nx) > BOUNDARY || Math.abs(ny) > BOUNDARY) {
					atom.isRemoved = true;
					continue;
				}

				String key = nx + "," + ny;
				if (!positions.containsKey(key)) {
					positions.put(key, new ArrayList<>());
				}
				positions.get(key).add(atom);

				// 중간 지점 충돌 체크
				if ((atom.x + nx) % 2 == 0 && (atom.y + ny) % 2 == 0) {
					String midKey = ((atom.x + nx) / 2) + "," + ((atom.y + ny) / 2);
					if (!positions.containsKey(key)) {
						positions.put(key, new ArrayList<>());
					}
					positions.get(key).add(atom);
				}

				atom.x = nx;
				atom.y = ny;
			}

			// 충돌한 원소 소멸
			for (List<Atom> collided : positions.values()) {
				if (collided.size() > 1) {
					for (Atom atom : collided) {
						if (!atom.isRemoved) {
							totalEnergy += atom.energy;
							atom.isRemoved = true;
						}
					}
				}
			}

			atoms.removeIf(atom -> atom.isRemoved);
		}
	}
}