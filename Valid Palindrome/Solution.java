/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

@https://leetcode.com/problems/valid-palindrome/
*/


import java.io.*;
import java.util.*;

public class Solution {
    
    public boolean isAlpha(char a)
    {
    	return (a>='A'&&a<='Z')||(a>='a'&&a<='z')||(a>='0'&&a<='9');
    }

    public boolean isPalindrome(String s) {
    	int i = 0;
    	int j = s.length()-1;
    	char a,b;
    	while(i < j){
    		a = s.charAt(i);
    		while(!isAlpha(a) && i < j){
    			a = s.charAt(++i);
    		}
    		b = s.charAt(j);
    		while(!isAlpha(b) && i < j){
    			b = s.charAt(--j);
    		}
    		if(i<j && Character.toLowerCase(a)!=Character.toLowerCase(b)){
    			return false;
    		}
    		i++;j--;
    	}
    	return true;
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	println(s.isPalindrome("1a2"));    
    }
}