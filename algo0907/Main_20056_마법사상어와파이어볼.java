package algo0907;

import java.io.*;
import java.util.*;

class Fireball{
	int r,c,m,s,d;
	public Fireball(int r,int c,int m, int s,int d) {
		this.r = r;
		this.c = c;
		this.m = m; //질량
		this.s = s; //속력
		this.d = d; //방향
	}
}
public class Main_20056_마법사상어와파이어볼 {
	static int[] dr = {-1,-1,0,1,1, 1, 0,-1};
	static int[] dc = { 0, 1,1,1,0,-1,-1,-1};
	static ArrayList<Fireball> fireballs;
	static int N,M,K;
	static Map<String, ArrayList<Fireball>> fmap;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		fireballs = new ArrayList<Fireball>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireballs.add(new Fireball(r, c, m, s, d));
		}
		fmap = new HashMap<String, ArrayList<Fireball>>();
		simul();
	}

	static void simul() {


		while(K-- != 0) {
			//이동
			move();

			//합치기
			merge();
		}
		int ans = 0;
		for(Fireball fb : fireballs)ans+= fb.m;
		System.out.println(ans);

	}
	static void move() {
		for(Fireball fb : fireballs) {

			int nr = (fb.r + dr[fb.d] * (fb.s % N)) % N;
			int nc = (fb.c + dc[fb.d] * (fb.s % N)) % N;

			if (nr < 0) nr += N;
			if (nc < 0) nc += N; 
			//			System.out.println("cur s " + fb.s + " cur d : " + fb.d);
			//			System.out.println("cur r : " + fb.r + " cur c : " + fb.c);
			//			System.out.println("nr : " + nr + " nc : " + nc);
			//			System.out.println();
			fb.r = nr;
			fb.c = nc;
			if(!fmap.containsKey(nr+","+nc)) {
				fmap.put(nr+","+nc,new ArrayList<Fireball>());
			}
			fmap.get(nr+","+nc).add(fb);
		}
	}
	static void merge() {
		fireballs.clear();

		for(ArrayList<Fireball> list : fmap.values()) {
			if(list.size() >= 2) {

				boolean allEven = true;
				boolean allOdd = true;

				int r = list.get(0).r;
				int c = list.get(0).c;
				int new_m = 0;
				int new_s = 0;

				for(Fireball fb : list) {
					new_m += fb.m;
					new_s += fb.s;
					if(fb.d % 2 == 0) allOdd = false;
					else allEven = false;
				}
				new_m /= 5;

				if(new_m < 1 ) {
					list.clear();
					continue;
				}
				new_s = (new_s/list.size());

				if(allEven || allOdd) {
					fireballs.add(new Fireball(r, c, new_m, new_s, 0));
					fireballs.add(new Fireball(r, c, new_m, new_s, 2));
					fireballs.add(new Fireball(r, c, new_m, new_s, 4));
					fireballs.add(new Fireball(r, c, new_m, new_s, 6));
				}else {
					fireballs.add(new Fireball(r, c, new_m, new_s, 1));
					fireballs.add(new Fireball(r, c, new_m, new_s, 3));
					fireballs.add(new Fireball(r, c, new_m, new_s, 5));
					fireballs.add(new Fireball(r, c, new_m, new_s, 7));
				}
			}else if(list.size()== 1){
				fireballs.add(list.get(0));
			}
		}
		fmap.clear();
	}
}