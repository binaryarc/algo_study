package algo1026;

import java.io.*;
import java.util.*;

public class Main_5052_전화번호목록 {
	static class TrieNode {
		Map<Character, TrieNode> childNode = new HashMap<Character, TrieNode>();
		boolean endOfWord;

		boolean insert(String str) {
			TrieNode node = this;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (node.endOfWord) {
					// 현재 노드가 이미 어떤 단어의 끝이라면, 접두어 관계가 발생하므로 일관성 없음
					return false;
				}
				node = node.childNode.computeIfAbsent(c, key -> new TrieNode());
			}
			// 저장 할 문자열의 마지막 단어에 매핑되는 노드에 단어의 끝임을 명시
			node.endOfWord = true;
			// 마지막에 도달했을 때 자식 노드가 있는 경우도 일관성 없음 (다른 번호가 현재 번호의 접두어임)
			if (!node.childNode.isEmpty()) {
				return false;
			}
			return true;
		}

		// 해당 문제에는 관계없지만 트라이 공부할겸 작성!
		boolean search(String str) {
			TrieNode node = this;
			for (int i = 0; i < str.length(); i++) {
				node = node.childNode.getOrDefault(str.charAt(i), null);
				if (node == null)
					return false;
			}
			return node.endOfWord;
		}
	}

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			TrieNode root = new TrieNode();
			boolean isAvail = true;
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				if (!root.insert(str)) {
					isAvail = false;
					for (int j = i + 1; j < N; j++) {
                        br.readLine();
                    }
					break; // 일관성 없음
				}
			}
			if (isAvail) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
}
