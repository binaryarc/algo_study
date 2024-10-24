package algo1024;

import java.util.*;
import java.io.*;

public class Main_15828_router {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new ArrayDeque<Integer>();
		int N = Integer.parseInt(st.nextToken());
		while(true) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			if(input == -1)break;
			if(input == 0) {
				q.poll();
				continue;
			}
			if(q.size() == N) {
				continue;
			}else {
				q.add(input);
			}
		}
		if(q.isEmpty())System.out.println("empty");
		else {
			int s = q.size();
			for(int i=0;i<s;i++)System.out.print(q.poll()+" ");
		}
		
	}
}
