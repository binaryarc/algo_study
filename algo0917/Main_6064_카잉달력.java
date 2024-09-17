package algo0917;

import java.util.*;
import java.io.*;

public class Main_6064_카잉달력 {
	static int T;
	static int N,M,x,y;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i=0;i<T;i++) {
			M = sc.nextInt();
			N = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			System.out.println(find()); 
		}
	}
	
	static int find() {
		int year = x;
		int L = M*N;
		while(year <= L) {
			if((year -1) % N + 1 == y) {
				return year;
			}
			year += M;
		}
		return -1;
		
	}
}
