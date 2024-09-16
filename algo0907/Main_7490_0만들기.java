package algo0907;

import java.util.*;
import java.io.*;
public class Main_7490_0만들기 {
	static int n;
	static int[] nums;
	static ArrayList<String> resList;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			resList = new ArrayList<String>();
			n = sc.nextInt();
			nums = new int[n+1];
			for(int i=1;i<=n;i++) {
				nums[i] = i;
			}
			
			dfs(2,nums[1],""+nums[1],false);
			for(String str : resList)System.out.println(str);
			System.out.println();
		}
	}
	static void dfs(int cnt,int prev_num, String prev_exp,boolean containBlank) {
		if(cnt == n+1) {
			if (!prev_exp.contains("+") && !prev_exp.contains("-")) return;
			if(!containBlank && prev_num == 0) {
				resList.add(prev_exp);
				return;
			}else {
				String origin_exp = prev_exp;
				prev_exp = prev_exp.replace(" ", "");
				String tempNum="";
				int res = 0;
				for(int i = prev_exp.length() - 1 ; i >= 0 ;i--) {
					char temp = prev_exp.charAt(i);
					if(temp -'0' < 10 && temp -'0' > -1) {
						tempNum = temp + tempNum;
					}else {
						if(temp == '+') {
							res += Integer.parseInt(tempNum);
							tempNum = "";
							
						}else if(temp == '-' ) {
							res -= Integer.parseInt(tempNum);
							tempNum = "";
						}
					}
				}
				res += Integer.parseInt(tempNum);
				if(res == 0) {
					resList.add(origin_exp);
				}
			}
			return;
		}
		dfs(cnt+1, prev_num + nums[cnt] ,prev_exp+" "+nums[cnt],true);
		if(prev_exp.contains(" ")) {
			dfs(cnt+1,prev_num+nums[cnt],prev_exp+"+"+nums[cnt],true);
			dfs(cnt+1,prev_num-nums[cnt],prev_exp+"-"+nums[cnt],true);
		}else {
			dfs(cnt+1,prev_num+nums[cnt],prev_exp+"+"+nums[cnt],false);
			dfs(cnt+1,prev_num-nums[cnt],prev_exp+"-"+nums[cnt],false);
		}
	}

}