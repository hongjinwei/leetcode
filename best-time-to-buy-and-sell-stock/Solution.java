/*
Best Time to Buy and Sell Stock Total Accepted: 48707 Total Submissions: 149635 My Submissions Question Solution 
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

@https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/
import java.io.*;
import java.util.*;

public class Solution {
       
    public int maxProfit(int[] prices) {
    	int len = prices.length;
    	int[] profit = new int[len];
    	if(len == 0) return 0;
    	profit[0] = 0;
    	int min = prices[0];
    	int max = 0;
    	for(int i=1;i<len;i++){
    		profit[i] = Math.max(profit[0],prices[i] - min);
    		min = Math.min(min,prices[i]);
    		if(max<profit[i]){
    			max = profit[i];
    		}
    	}
    	//println(Arrays.toString(profit));
    	return max;
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] p = {};
    	println(s.maxProfit(p));    
    }
}