package algo1116;

import java.util.*;
public class test {
	public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    
	    int result = -1;
	    int fiveCnt = n / 5;
	    
	    while(fiveCnt >= 0) {
	        int remainder = n - (fiveCnt * 5);
	        if(remainder % 2 == 0) {
	            result = fiveCnt + (remainder / 2);
	            break;
	        }
	        fiveCnt--;
	    }
	    
	    System.out.println(result);
	}
}
