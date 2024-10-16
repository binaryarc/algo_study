package algo1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_11478_서로다른부분문자열의개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Set<String> substr = new HashSet<String>();
		int N = input.length();
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				substr.add(input.substring(i, j));
			}
		}
		System.out.println(substr.size());
	}
}
