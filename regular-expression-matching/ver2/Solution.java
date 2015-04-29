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

    public boolean isMatch(String s, String p)
    {
        int lenp = p.length();
        int lens = s.length();
        System.out.println(s);
        System.out.println(p);

    	if(lenp == 0){
 			return lens == 0;
 		}

        if(lenp == 1){
            if(p.equals("*")){
                return true;
            }else if(p.equals(".") && lens==1){
                return true;
            }else if(p.equals(s)){
                return true;
            }
            return false;
        }
        
        if(p.charAt(1) == '*'){
            while(s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') ){
                if(isMatch(s,p.substring(2))){
                    return true;
                }
                s = s.substring(1);
            }

            return isMatch(s,p.substring(2));
        }else{
            if(lens > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1))){
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	String a = "ab";
    	String b = ".*c";
        //a.substring(2);
    	System.out.println(s.isMatch(a,b));    
    }
}
