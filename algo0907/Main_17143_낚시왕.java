package algo0907;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 
 */

class Shark implements Comparable<Shark>{
	int r, c, d, s ,z;
	public Shark(int r,int c,int s,int d,int z) {
		this.r = r; //행
		this.c = c; //열
		this.s = s; //속력
		this.d = d; //방향
		this.z = z; //크기
	}
	@Override
	public int compareTo(Shark other) {
		return other.z - this.z;
	}
}

public class Main_17143_낚시왕 {

	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0, 0,0,1,-1};
	static int R,C,M; //행, 열, 상어수
	static PriorityQueue<Shark>[][] map;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new PriorityQueue[R+1][C+1];

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = new PriorityQueue<>();
			}
		}

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r,c,s,d,z;
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());

			if(d <= 2) {
				//상 하 이면
				s = s % (2 * (R - 1));
			}else {
				//좌 우 이면
				s = s % (2 * (C - 1));
			}
			map[r][c].add(new Shark(r, c, s, d, z));
		}
		ans = 0;
		solve();
	}
	static void solve() {
		int fisherPoint = 0;
		while(++fisherPoint <= C) {
			//낚시
			fishing(fisherPoint);

			//이동
			move();

			//서로 잡아먹기
			merge();
		}
		System.out.println(ans);
	}

	static void fishing(int c) {

		for(int i = 1 ;i <= R ; i++) {
			if(!map[i][c].isEmpty()) {
				Shark shark = map[i][c].poll();
				ans += shark.z;
				return;
			}
		}
	}

	static void move() {
		
		//이동전 담아둘 임시 우선순위큐
		PriorityQueue<Shark> tempShark = new PriorityQueue<Shark>();
		
		// 기존 map 초기화 하면서 리스트에 넘김
		// map은 다비워지게 됨
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				while(!map[i][j].isEmpty()) {
					tempShark.add(map[i][j].poll());
				}
			}
		}
		while(!tempShark.isEmpty()) {
			Shark shark = tempShark.poll();
			int r = shark.r;
			int c = shark.c;
			int s = shark.s;
			int d = shark.d;
			for(int i = 0; i < s ; i++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 1 || nr > R || nc < 1 || nc > C) {
					d =  (d % 2 == 0) ? d - 1 : d + 1;
					nr = r + dr[d];
					nc = c + dc[d];
				}
				r = nr ;
				c = nc ;
			}

			shark.r = r;
			shark.c = c;
			shark.d = d;
			map[r][c].add(shark);
		}
	}

	static void merge() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (!map[i][j].isEmpty()) {
					//가장큰 상어만 남김
					Shark shark = map[i][j].poll();
					map[i][j].clear();
					map[i][j].add(shark);
				}
			}
		}
	}
}