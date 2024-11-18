package algo1117;

import java.util.*;
import java.io.*;

public class Main_11399_ATM {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		int time = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				time += arr[j];
			}
		}
		System.out.println(time);
	}
}
