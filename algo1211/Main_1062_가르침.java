package algo1211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
    static int N, K, ans;
    static int[] words;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }

        // 필수 문자 비트마스크 ('a', 'n', 't', 'i', 'c')
        int mandatoryMask = 0;
        mandatoryMask |= 1 << ('a' - 'a');
        mandatoryMask |= 1 << ('n' - 'a');
        mandatoryMask |= 1 << ('t' - 'a');
        mandatoryMask |= 1 << ('i' - 'a');
        mandatoryMask |= 1 << ('c' - 'a');

        K -= 5; // 필수 문자 제외한 K 개수
        words = new int[N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int mask = 0;
            for (char ch : str.toCharArray()) {
                mask |= 1 << (ch - 'a');
            }
            words[i] = mask;
        }

        ans = 0;
        select(0, 0, mandatoryMask);
        System.out.println(ans);
    }

    // 백트래킹
    public static void select(int idx, int count, int mask) {
        if (count == K) {
            ans = Math.max(ans, countReadable(mask));
            return;
        }

        for (int i = idx; i < 26; i++) {
            if ((mask & (1 << i)) == 0) { // 아직 선택되지 않은 문자
                select(i + 1, count + 1, mask | (1 << i));
            }
        }
    }

    // 읽을 수 있는 단어 개수 계산
    public static int countReadable(int mask) {
        int cnt = 0;
        for (int word : words) {
            if ((word & mask) == word) { // 단어의 모든 문자가 현재 선택된 문자에 포함되는지 확인
                cnt++;
            }
        }
        return cnt;
    }
}
