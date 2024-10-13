package algo1013;

import java.util.Scanner;

public class Main_1072_게임 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long game_cnt = sc.nextLong();
		long score = sc.nextLong();

		long origin_per = (score * 100) / game_cnt;
		long left = 0;
		long right = game_cnt;
		long ans = -1;
		while (left <= right) {
			long mid = (left + right) / 2;
			long new_game_cnt = game_cnt + mid;
			long new_per = ((score + mid) * 100) / new_game_cnt;

			if (new_per > origin_per) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans);

	}
}
