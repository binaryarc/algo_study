package algo1012;

import java.io.*;
import java.util.*;

/*
 * 주어지는 이동방향 0상 , 1하 , 2좌 ,3우 
 * 1초에 1만큼 이동
 * 모든 원자들은 최초 위치에서 동시에 이동시작
 * 두 개이상 원자 충돌 할 경우 보유한 에너지를 방출하고 소멸
 */
public class Solution_5648_원자소멸시뮬레이션 {
	static class Atom {
		int x, y;
		int energy;
		int dir;

		public Atom(int x, int y, int d, int e) {
			this.x = x;
			this.y = y;
			this.dir = d;
			this.energy = e;
		}
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N;
	static int[][] board;
	static int cur_cnt;
	static int cur_emmit;
	static List<Atom> list;
	static Map<String, ArrayDeque<Atom>> map;
	static final int BOUNDARY = 2000; // 경계 설정

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {

			list = new ArrayList<Atom>();
			map = new HashMap<String, ArrayDeque<Atom>>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()); // 이동방향
				int K = Integer.parseInt(st.nextToken()); // 에너지
				list.add(new Atom(x, y, dir, K));
			}
			solve();
			System.out.println("#" + tc + " " + cur_emmit);

		}
	}

	private static void solve() {
		cur_cnt = N;
		cur_emmit = 0;
		while (cur_cnt > 1) {
			checkMidpointCollisions();
			move();
			boom();
			if (cur_cnt <= 1) {
				return;
			}

		}
	}

	private static void checkMidpointCollisions() {
		boolean[] isDeleted = new boolean[list.size()];

		for (int i = 0; i < list.size(); i++) {
			if (isDeleted[i])
				continue;
			Atom atom1 = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				if (isDeleted[j])
					continue;
				Atom atom2 = list.get(j);
				// 서로 반대 방향에서 중간 지점에서 만나서 충돌하는지 확인
				if (checkCollision(atom1, atom2)) {
					cur_emmit += (atom1.energy + atom2.energy);
					isDeleted[i] = true;
					isDeleted[j] = true;
					break;
				}
			}
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			if (isDeleted[i]) {
				list.remove(i);
			}
		}
		System.out.println(cur_emmit);
		cur_cnt = list.size();
	}

	private static boolean checkCollision(Atom atom1, Atom atom2) {
		return (atom1.dir == 0 && atom2.dir == 1 && atom1.y == atom2.y + 1 && atom1.x == atom2.x)
				|| (atom1.dir == 1 && atom2.dir == 0 && atom1.y == atom2.y - 1 && atom1.x == atom2.x)
				|| (atom1.dir == 2 && atom2.dir == 3 && atom1.x == atom2.x + 1 && atom1.y == atom2.y)
				|| (atom1.dir == 3 && atom2.dir == 2 && atom1.x == atom2.x - 1 && atom1.y == atom2.y);
	}

	private static void boom() {
		List<Atom> newList = new ArrayList<Atom>();
		for (ArrayDeque<Atom> atoms : map.values()) {
			if (atoms.size() >= 2) {
				while (!atoms.isEmpty()) {
					Atom at = atoms.poll();
					cur_emmit += at.energy;
					cur_cnt--;
				}
			} else if (atoms.size() == 1) {
				newList.add(atoms.poll());
			}
		}
		list = newList;
	}

	private static void move() {
		map.clear();
		Iterator<Atom> iter = list.iterator();
		while (iter.hasNext()) {

			Atom atom = iter.next();

			atom.y += dr[atom.dir];
			atom.x += dc[atom.dir];

			if (Math.abs(atom.x) > BOUNDARY || Math.abs(atom.y) > BOUNDARY) {
				iter.remove();
				cur_cnt--;
				continue;
			}

			String key = atom.x + "," + atom.y;
			if (!map.containsKey(key)) {
				map.put(key, new ArrayDeque<>());
			}

			map.get(key).offer(atom);

		}

	}
}
