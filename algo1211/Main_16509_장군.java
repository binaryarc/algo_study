package algo1211;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_16509_장군 {
    static int r1, r2, c1, c2;
    static int[][] move = { 
        { -3, -2 }, { -3, 2 }, { 3, -2 }, { 3, 2 }, 
        { -2, -3 }, { -2, 3 }, { 2, -3 }, { 2, 3 } 
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r1 = sc.nextInt(); // 나이트 위치
        c1 = sc.nextInt();
        r2 = sc.nextInt(); // 왕 위치
        c2 = sc.nextInt();
        sc.close();

        int ans = bfs();
        System.out.println(ans);
    }

    static int bfs() {
        boolean[][] visited = new boolean[10][9];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r1, c1});
        visited[r1][c1] = true;

        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                // 목표 지점 도달
                if (current[0] == r2 && current[1] == c2) {
                    return moves;
                }

                // 8방향 이동
                for (int[] m : move) {
                    int nr = current[0] + m[0];
                    int nc = current[1] + m[1];

                    // 보드 범위 체크
                    if (nr < 0 || nr >= 10 || nc < 0 || nc >= 9 || visited[nr][nc]) {
                        continue;
                    }

                    // 왕을 지나가는 경우 체크
                    if (isBlockedByKing(current[0], current[1], nr, nc)) {
                        continue;
                    }

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
            moves++;
        }
        return -1;
    }

    static boolean isBlockedByKing(int r, int c, int nr, int nc) {
        // 이동 방향에 따라 중간 지점 확인
        // 첫 번째 중간 점
        int mr1 = r + (nr - r) / 3;
        int mc1 = c + (nc - c) / 3;

        // 두 번째 중간 점 
        int mr2 = r + 2 * (nr - r) / 3;
        int mc2 = c + 2 * (nc - c) / 3;

        // 중간 지점들이 보드 범위 내에 있는지 확인
        if (mr1 < 0 || mr1 >= 10 || mc1 < 0 || mc1 >= 9 ||
            mr2 < 0 || mr2 >= 10 || mc2 < 0 || mc2 >= 9) {
            return false;
        }

        // 두 중간 지점 중 하나라도 왕의 위치와 일치하면 막힌 것
        return (mr1 == r2 && mc1 == c2) || (mr2 == r2 && mc2 == c2);
    }
}