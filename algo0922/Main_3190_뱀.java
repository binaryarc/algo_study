package algo0922;

import java.util.*;
import java.io.*;

public class Main_3190_뱀 {
	static int[] dr = {-1,0,1, 0}; //상 우 하 좌
	static int[] dc = { 0,1,0,-1};
	static int N,K,L;
	static List<int[]> apples;
	static int cur_r = 1;
	static int cur_c = 1;
	static int cur_d = 1;
	static int[][] map;
	static char[] dirInfo;
	static int ans_time;
	static ArrayDeque<int[]> q = new ArrayDeque<int[]>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //보드크기 N*N;

		map = new int[N+1][N+1];
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken()); //사과개수
		apples = new ArrayList<int[]>();
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); //방향전환 횟수
		dirInfo = new char[10001];
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().toCharArray()[0];
			dirInfo[time] = dir;
		}
		
		simul();
		System.out.println(ans_time);
	}
	static void simul() {
		
		ans_time = 0;
		map[1][1] = -1;
		
		while(true) {
			ans_time++;
			
			q.offer(new int[] {cur_r,cur_c});
			int next_r = cur_r + dr[cur_d];
            int next_c = cur_c + dc[cur_d];
            
            if (next_r < 1 || next_r > N || next_c < 1 || next_c > N || map[next_r][next_c] == -1) {
                break; // 게임 종료 조건
            }
            
            move(next_r, next_c);
            
			if(dirInfo[ans_time] == 'L' || dirInfo[ans_time] == 'D' ) {
				dirChange(ans_time);
			}
		}
	}
	
	static void dirChange(int time) {
		if (dirInfo[time] == 'L') {
            cur_d = (cur_d + 3) % 4; // 왼쪽으로 90도 회전
        } else { // 오른쪽 90도
            cur_d = (cur_d + 1) % 4; // 오른쪽으로 90도 회전
        }
	}
	static void move(int r, int c) {
		cur_r = r;
		cur_c = c;
		if (map[r][c] == 1) {
            map[r][c] = -1; // 사과 먹음, 뱀이 길어짐
        } else {
            map[r][c] = -1; // 뱀의 위치 업데이트
            int[] tail = q.pollFirst(); // 꼬리 제거
            map[tail[0]][tail[1]] = 0; // 꼬리였던 자리 비우기
        }
	}
}
