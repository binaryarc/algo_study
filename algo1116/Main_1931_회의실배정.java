package algo1116;

import java.io.*;
import java.util.*;

public class Main_1931_회의실배정 {
	static class MeetingRoom implements Comparable<MeetingRoom> {
		long start, end;
		long time;

		public MeetingRoom(Long start, Long end) {
			this.start = start;
			this.end = end;
			this.time = end - start;
		}

		@Override
		public int compareTo(MeetingRoom o) {
			if (this.end == o.end) {
				return Long.compare(this.start, o.start);
			} else {
				return Long.compare(this.end, o.end);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<MeetingRoom> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
			list.add(new MeetingRoom(start, end));
		}

		// 종료 시간을 기준으로 정렬
		Collections.sort(list);
		
		long curTime = 0;
		int cnt = 0;
		
//		for (MeetingRoom room : list) {
//			System.out.println(room.start + " " + room.end);
//		}
		
		for (MeetingRoom room : list) {
			if (curTime <= room.start) { // 현재 회의의 시작 시간이 현재 시간 이후라면 선택
				curTime = room.end; // 현재 시간을 업데이트
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
