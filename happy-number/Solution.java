/*


@
*/
import java.io.*;
import java.util.*;

public class Solution {
    
	HashMap<Integer, Integer> repeated = new HashMap<Integer, Integer>();

	public int getNewNumber(int n) {
		int tmp;
		int ans = 0;
		while(n > 0){
			tmp = n % 10;
			ans += tmp * tmp;
			n = n/10;
		}
		return ans;
	}

    public boolean isHappy(int n) {
        repeated.clear();
        repeated.put(n,1);
        int ans = n;
        for(;;){
        	ans = getNewNumber(ans);
        	if(ans == 1) return true;
        	if(repeated.containsKey(ans)) return false;
        	repeated.put(ans, 1);
        }

    }

	public static void println(Object obj){
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	println(s.isHappy(18));    
    }
}