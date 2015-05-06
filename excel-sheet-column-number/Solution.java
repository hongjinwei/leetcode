/*
Excel Sheet Column Number Total Accepted: 26379 Total Submissions: 71538 My Submissions Question Solution 
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
Credits:
Special thanks to @ts for adding this problem and creating all test cases.

@https://leetcode.com/problems/excel-sheet-column-number/
*/
import java.io.*;
import java.util.*;

public class Solution {
    
    public int titleToNumber(String s) {
    	int res = 0;
    	for(int i = 0; i<s.length(); i++){
    		res = res*26;
    		//println(res);println(s.charAt(i));
    		res += s.charAt(i) - 64;
    	}
    	return res;    
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int a = 'A';
    	println(s.titleToNumber("AC"));    
    }
}