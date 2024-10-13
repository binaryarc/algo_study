package algo0924;

import java.io.*;
import java.util.*;

public class Main_14469_소가길을건너간이유3 {
	static class Cow implements Comparable<Cow>{
		int t1;
		int t2;
		public Cow(int t1,int t2){
			this.t1 = t1;
			this.t2 = t2;
		}

		@Override
		public int compareTo(Cow o) {
			if(t1 != o.t1) {
				return t1 - o.t1;
			}else {
				return t2 - o.t2;
			}
		}
		
	}
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Cow> pq = new PriorityQueue<Cow>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a_t = Integer.parseInt(st.nextToken());
			int c_t = Integer.parseInt(st.nextToken());
			pq.add(new Cow(a_t,c_t));
		}
		
		int time = 0;
		while(!pq.isEmpty()) {
			Cow cow = pq.poll();
			if(time < cow.t1) {
				time = cow.t1;
				time += cow.t2;
			}else {
				time += cow.t2;
			}
		}
		
		System.out.println(time);
		
		
	}

}
