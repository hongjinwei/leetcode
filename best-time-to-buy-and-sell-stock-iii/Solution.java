import java.io.*;
import java.util.*;

public class Solution {
	    
	private void getProfit(int[] prices, int left[],int right[],int len)
	{
		left[0] = 0;
		right[len-1] = 0;

		int min = prices[0];
		for(int i=1; i < len; i++){
			left[i] = Math.max(left[i-1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		int max = prices[len-1];
		for(int i=len-2; i >= 0; i--){
			right[i] = Math.max(right[i+1], max-prices[i]);
			max = Math.max(prices[i], max);
		}

		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
	}

    public int maxProfit(int[] prices){
    	if(prices.length <= 1){
    		return 0;
    	}else{
    		int max = 0;
    		int tmp;
    		int len = prices.length;
    		int[] left = new int[len];
    		int[] right = new int[len];

    		getProfit(prices,left,right,len);

    		for(int i=0;i<prices.length;i++){
    			tmp = left[i] + right[i];
    			if(max < tmp){
    				max = tmp;
    			}
    		}
    		return max;
    	}
    }

    public static void main(String[] args)
    {
    	int prices[] = {1,4,3,6,5};
    	Solution s = new Solution();
    	System.out.println(s.maxProfit(prices));
    }
}