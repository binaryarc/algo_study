package algo0924;

import java.io.*;
import java.util.*;

public class Main_22981_휴먼파이프라인 {
	static int N;
	static long K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)->o1-o2);
		for(int i=0;i<N;i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		long time = Long.MAX_VALUE;
		int A_time = pq.poll();
		while (!pq.isEmpty()) {
			long teamA = (long) A_time * (N - pq.size()); //int 타입이 문제였음..
			long teamB = (long) pq.peek() * pq.size(); 
            long v = teamA + teamB;
            if (v == 0) {
                break; // v가 0인 경우 불가능한 상황이므로 종료
            }
            long tempTime = K / v; // 총 시간 계산
            if (K % v != 0) {      // 나머지가 있으면 1초 더 필요
                tempTime++;
            }
            time = Math.min(time, tempTime); // 최소 시간 갱신
            pq.poll(); // 팀 B에서 가장 느린 사람 한 명을 제외하고 다시 계산
        }
		System.out.println(time);
		
		
	}

}
