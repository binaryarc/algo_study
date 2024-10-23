package algo1023;

import java.io.*;
import java.util.*;

public class Main_14584_암호해독 {
	static String[] arr;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		for (int i = 0; i <= 26; i++) {
			String str = "";
			for (int j = 0; j < input.length(); j++) {
				char ch = (char) (((int) input.charAt(j) + i - 'a') % 26 + 'a');
				str += ch;
			}

			for (int k = 0; k < N; k++) {
				if(str.contains(arr[k])) {
					System.out.println(str);
					return;
				}
			}
		}
	}
}
