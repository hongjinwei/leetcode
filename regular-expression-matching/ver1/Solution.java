/*
Regular Expression Matching Total Accepted: 39582 Total Submissions: 191460 My Submissions Question Solution 
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

@https://leetcode.com/problems/regular-expression-matching/
*/
import java.io.*;
import java.util.*;
//this is a regex pattern
public class Solution {
    
    public boolean isMatch(String s, String p) {
 		System.out.println(s);
 		System.out.println(p);
 		if(s.length() == 0){
 			if(p.length() == 0){
 				return true;
 			}else{
 				for(int i=0;i<p.length();i++){
 					if(!p.substring(i,i+1).equals("*")){
 						return false;
 					}
 				}
 				return true;
 			}
 		}else if(p.length() == 0){
 			return false;
 		}else if(p.length() == 1 && p.equals("*")){
 			return true;
 		}else{
 			if( p.substring(0,1).equals(".")){
				return isMatch(s.substring(1), p.substring(1));
			}else if( p.substring(0,1).equals("*") ){
				boolean flag = false;
				for(int i=0;i<s.length();i++){
					flag = isMatch(s.substring(i),p.substring(1));
					if(flag){
						return true;
					}
				}
				return false;
			}else{
				if(!s.substring(0,1).equals(p.substring(0,1)) ){
					return false;
				}else{
					return isMatch(s.substring(1),p.substring(1));
				}
			}

 		}
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	String a = "aab" ;//"bbbacbcbcbbbbabbbab";
    	String b = "c*a*b" ;//"b*c*c*.*.*.*ab*c";
    	System.out.println(s.isMatch(a,b));    
    }
}