package algo0925;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
	static int N,K;
	static List<String> originList;
	static List<String> trimList;
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == 5) {
			System.out.println(0);
			return;
		}
		
		originList = new ArrayList<String>();
		trimList = new ArrayList<String>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			str = str.substring(4, str.length()-4);
			originList.add(str);
			String temp = "";
			for(char ch : str.toCharArray()) {
				if(ch == 'a' || ch =='n' || ch == 't' || ch == 'i' || ch =='c')continue;
				temp+=ch;
			}
			if(temp.length()>=1)trimList.add(temp);
			else trimList.add(null);
		}
		
		
	}
	static void dfs(int cnt, int cur_k, ArrayList<String> s_list) {
		if(cur_k == K) {
			ans = Math.max(ans, s_list.size());
		}
		
		
		
	}
}
