/*Excel Sheet Column Title
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

@https://leetcode.com/problems/excel-sheet-column-title/
*/
import java.io.*;
import java.util.*;

public class Solution {
    
	public String convertToTitle(int n) 
	{
		char a = 'A';
		String res = new String();
		res = "";
		int diff;
		while(n > 0){
			diff = n%26;
			res =  (char)(a + ( (diff == 0)?25:(diff-1) ) ) + res;
			n = (n-1) / 26;
		}
		//System.out.println(res);
		return res;
	}

    public static void main(String[] args) {
    	Solution s = new Solution();

    	//for(int i=28;i<100;i++){
    		System.out.println(s.convertToTitle(2147483647));    
    	//}
    		System.out.println(2147483647%26 );
    System.out.println(s.convertToTitle(23));  
    }
}