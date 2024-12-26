package algo1124;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_2981_검문 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		while (N-- != 0) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);

		
		//인접한 수 차이계산
		int gcdRes = list.get(1) - list.get(0);
		for (int i = 2; i < list.size(); i++) {
			gcdRes = gcd(gcdRes, list.get(i) - list.get(i - 1));
		}

		//최대공약수의 모든 약수 찾기
		List<Integer> ans = new ArrayList<>();
		for (int i = 2; i <= Math.sqrt(gcdRes); i++) {
			if (gcdRes % i == 0) {
				ans.add(i);
				if (i != gcdRes / i) {
					ans.add(gcdRes / i);
				}
			}
		}
		ans.add(gcdRes);
		Collections.sort(ans);
		for(int num : ans) {
			System.out.print(num + " ");
		}
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

}
