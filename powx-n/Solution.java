/*


@
*/
import java.io.*;
import java.util.*;

public class Solution {
    
    public double myPow(double x, int n) {
    	if(n == 0) return 1;
    	if(x == 0) return 0;
    	if(n < 0) { x = 1/x; n = -n;}
    	double result = 1;
    	while(n >0){
    		if((n & 0x1) == 1){
    			result *= x;
    		}
    		x = x*x;
    		n = n>>1;
    	}
    	return result;
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	println(s.myPow(4,3));    
    }
}