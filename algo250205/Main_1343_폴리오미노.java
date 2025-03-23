package algo250205;

import java.io.*;
import java.util.*;

public class Main_1343_폴리오미노 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int countX = 0;
		
		for(char ch : input.toCharArray()) {
			if(ch == 'X') {
				countX++;
			}else {
				if(countX %2 != 0) {
					System.out.println(-1);
					return;
				}
				while(countX >= 4) {
					sb.append("AAAA");
					countX -= 4;
				}
				if(countX == 2) {
					sb.append("BB");
					countX -=2;
				}
				sb.append(".");
			}
		}
		
		if(countX % 2 !=0) {
			System.out.println(-1);
			return;
		}
		while(countX >= 4) {
			sb.append("AAAA");
			countX-=4;
		}
		if(countX == 2) {
			sb.append("BB");
		}
		System.out.println(sb);
		
	}
}
