/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
@https://leetcode.com/problems/decode-ways/
*/
import java.io.*;
import java.util.*;

public class Solution {

	int process(String s){
		if(s.length() == 0 || s.length() == 1){
			return 1;
		}else{
			int tmp = Integer.parseInt( s.substring(0,2) );
			if( tmp == 10 || tmp ==20){
				return process(s.substring(2));
			}else if(Integer.parseInt( s.substring(0,2) ) <= 26 ){
				return process(s.substring(2)) + process(s.substring(1));
			}else{
				return process(s.substring(1));
			}
		}
	}

    public int numDecodings(String s) 
    {
    	int start = 0;
    	int res = 1;
    	boolean bigFlag = false;

    	if(s.length() == 0){
    		return 0;
    	}else if(s.substring(0,1).equals("0")){
    		return 0;
    	}

    	for(int i=1;i<s.length();i++){
    		int curr = Integer.parseInt( s.substring(i,i+1));
    		if( curr > 6){			
    			if(bigFlag){//if pre number is a bignumber larger than 6
    				start = i + 1;
    				continue;	
    			}else{
					bigFlag = true;
    			}

				res = res * process(s.substring(start,i+1));
				start = i + 1;
			}else if(curr == 0){
				//System.out.println(Integer.parseInt( s.substring(i-1,i) ));
				if( (i-1) < start || Integer.parseInt( s.substring(i-1,i) ) > 2 ){
					return 0;
				}else{
					res = res * process(s.substring(start,i-1));
					start = i + 1;
				}
				bigFlag = false;
			}else if( i == (s.length() - 1)){
    			res = res * process( s.substring(start,i+1) );
    		}else{
				bigFlag = false;
			}
		}
		return res;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();

    	String t = "10810910";
    	//System.out.println(s.process(t));
    	System.out.println(s.numDecodings(t));
    }
}