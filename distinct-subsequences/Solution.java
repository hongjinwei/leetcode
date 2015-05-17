/*
Distinct Subsequences Total Accepted: 31156 Total Submissions: 119420 My Submissions Question Solution 
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

@https://leetcode.com/problems/distinct-subsequences/
*/
import java.io.*;
import java.util.*;

public class Solution {
    

    // Time Limit Exceeded
	int count = 0;
	HashMap<String, String> err = new HashMap<String, String>();

	public boolean isErr(String s, String t) {
		if( s.length() == 0 || t.length() == 0 || s == null || t == null) return false;
		return err.containsKey(s) && err.get(s).equals(t);
	}

	public boolean process(String s, String t) {
		if(t.length() == 0 || t == null) {
			count++;
			return true;
		}
		if(s.length() == 0 || s == null || s.length() < t.length()) return false ;
		
		boolean flag = false;
		for(int i = 0; i < s.length(); i++){
			if( s.charAt(i) == t.charAt(0) && !isErr( s.substring(i+1), t.substring(1)) ){
				if( !process( s.substring(i+1), t.substring(1) ) ){
					for(int j = i+2; j<=s.length(); j++){
						err.put( s.substring(i+1, j), t.substring(1) );
					}
				}else{
					flag = true;
				}
			}
		}
		return flag;
	}

	public int numDistinct(String s, String t) {
        count = 0;
        err.clear();
        process(s,t);
        return count;
    }
	
	public static void println(Object obj){
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution solu = new Solution();
    	String s = "aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe";
    	String t = "bddabdcae";
    	println( solu.numDistinct(s, t) );    
    }
}