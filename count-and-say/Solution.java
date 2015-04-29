/*
Count and Say Total Accepted: 39991 Total Submissions: 157767 My Submissions Question Solution 
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
@https://leetcode.com/problems/count-and-say/
*/
import java.io.*;
import java.util.*;

public class Solution {
   
	private int[] process(int n)
	{
		if(n == 1){
			int[] tmp = {1};
			return tmp;
		}else{
			int[] tmp = process(n-1);
			LinkedList<Integer> res = new LinkedList<Integer>();
			int last = tmp[0], count = 1;

			for(int i =1;i<tmp.length;i++){
				if(tmp[i] == last){
					count++;
				}else{	
					res.add(count);				
					res.add(last);
					last = tmp[i];
					count = 1;
				}	
			}

			res.add(count);				
			res.add(last);
			//System.out.println(res);
			int[] s = new int[res.size()];
			for(int i=0;i<res.size();i++){
				s[i] = res.get(i);
			}

			return s;
		}
	}
	
    public String countAndSay(int n) 
    {
    	int[] s = process(n);
    	String res = "";
    	for(int i=0;i<s.length;i++){
    		res += s[i];
    	}
    	return res;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();

      	System.out.println(s.countAndSay(5));
    }
}