package algo0902;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5430_AC {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		Queue<Character> q = new ArrayDeque<Character>();
		while(T-- > 0) {
			StringBuilder result = new StringBuilder();
			char[] commands = br.readLine().toCharArray(); // 명령어 배열
			int size = Integer.parseInt(br.readLine()); // 배열 크기

			String input = br.readLine();
			Deque<Integer> deque = new ArrayDeque<>();
			if(size > 0) {
				String[] elements = input.substring(1, input.length() - 1).split(",");
				for(String element : elements) {
					deque.add(Integer.parseInt(element));
				}
			}

			boolean isReversed = false;
			boolean errorFlag = false;

			for(char command : commands) {
				if(command == 'R') {
					isReversed = !isReversed;
				} else if(command == 'D') {
					if(deque.isEmpty()) {
						errorFlag = true;
						break;
					}
					if(isReversed) {
						deque.removeLast();
					} else {
						deque.removeFirst();
					}
				}
			}

			if(errorFlag) {
				result.append("error");
			} else {
				result.append("[");
				while(!deque.isEmpty()) {
					result.append(isReversed ? deque.removeLast() : deque.removeFirst());
					if(!deque.isEmpty()) {
						result.append(",");
					}
				}
				result.append("]");
			}
			System.out.println(result);
		}
	}
}