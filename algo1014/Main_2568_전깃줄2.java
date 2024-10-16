package algo1014;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2568_전깃줄2 {
    static class Line implements Comparable<Line> {
        int a, b;

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Line other) {
            return this.a - other.a; // A 전봇대 기준으로 오름차순 정렬
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 전깃줄의 개수
        Line[] lines = new Line[N];

        // 전깃줄 정보를 입력받음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // A 전봇대 번호
            int b = Integer.parseInt(st.nextToken()); // B 전봇대 번호
            lines[i] = new Line(a, b);
        }

        // A 전봇대 기준으로 정렬 (B 전봇대는 그대로 둠)
        Arrays.sort(lines);

        // B 전봇대에서 LIS를 구하는 과정
        int res = lis(lines); // 최장 증가 부분 수열의 길이 계산

        // 제거할 전깃줄의 개수 출력
        System.out.println(N - res); 

        // LIS에 포함되지 않은 전깃줄들의 A 전봇대 번호 출력
        List<Integer> unusedLines = getUnusedLines(lines);
        for (int a : unusedLines) {
            System.out.println(a);
        }
    }

    // B 전봇대에서 최장 증가 부분 수열(LIS)을 구하는 함수
    private static int lis(Line[] lines) {
        int n = lines.length;
        int[] lis = new int[n]; // LIS를 저장할 배열
        int[] lisIdx = new int[n]; // LIS에 포함된 전깃줄의 인덱스 저장
        int[] trace = new int[n]; // LIS를 추적하기 위한 배열 (역추적)
        int lis_len = 0; // LIS의 길이

        // LIS 계산 과정
        for (int i = 0; i < n; i++) {
            int key = lines[i].b; // B 전봇대 번호를 기준으로 LIS 구하기
            int left = 0;
            int right = lis_len - 1;

            // 이분 탐색을 통해 LIS 배열에서 key가 들어갈 위치를 찾음
            while (left <= right) {
                int mid = (left + right) / 2;
                if (lis[mid] < key) {
                    left = mid + 1; // key가 더 크다면 오른쪽으로 이동
                } else {
                    right = mid - 1; // key가 더 작다면 왼쪽으로 이동
                }
            }

            lis[left] = key; // 찾은 위치에 key를 넣음
            lisIdx[left] = i; // 해당 위치에 있는 전깃줄 인덱스 저장
            trace[i] = (left > 0) ? lisIdx[left - 1] : -1; // 추적 배열 업데이트

            // 새로운 값을 넣는 위치가 현재 LIS의 끝이라면 길이를 증가시킴
            if (left == lis_len) {
                lis_len++;
            }
        }

        // LIS에 포함된 인덱스를 추적
        List<Integer> ans = new ArrayList<>();
        int idx = lisIdx[lis_len - 1]; // 마지막 LIS 원소 인덱스
        while (idx != -1) {
            ans.add(0, idx); // 역순으로 LIS에 포함된 인덱스를 추가
            idx = trace[idx];
        }

        usedLines = ans; // LIS에 포함된 전깃줄 인덱스를 저장
        return lis_len; // LIS의 길이를 반환
    }

    // LIS에 포함된 전깃줄 인덱스를 저장할 리스트
    static List<Integer> usedLines;

    // LIS에 포함되지 않은 전깃줄을 구하는 함수
    private static List<Integer> getUnusedLines(Line[] lines) {
        List<Integer> unused = new ArrayList<>();

        // 전체 lines 배열에서 LIS에 포함되지 않은 전깃줄의 a 값을 구함
        for (int i = 0; i < lines.length; i++) {
            if (!usedLines.contains(i)) { // LIS에 포함되지 않은 인덱스
                unused.add(lines[i].a); // 사용되지 않은 전깃줄의 A 값을 저장
            }
        }

        return unused;
    }
}
