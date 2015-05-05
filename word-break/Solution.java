/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

@https://leetcode.com/problems/word-break/
*/
import java.io.*;
import java.util.*;

public class Solution {
    
    Set<String> err = new HashSet<String>();
	boolean process(String s, Set<String> dict)
	{
		for(int i=1;i<=s.length();i++){
			if(dict.contains(s.substring(0,i))){
				if(i == s.length()){
					return true;
				}else{

					if( !err.contains(s.substring(i))){
						if(process(s.substring(i),dict)){
							return true;
						}else{
							err.add(s.substring(i));
						}
					}
				}
			}
		}
		return false;
	}

    public boolean wordBreak(String s, Set<String> wordDict)
    {
    	if(s.length() == 0){
    		if(wordDict.contains("")){
    			return true;
    		}
    		return false;
    	}
    	return process(s, wordDict);
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	Set<String> dict = new HashSet<String>();
    	dict.add("aaaa");
    	dict.add("aaa");
    	String p = "aaaaaaa";
    	println(s.wordBreak(p,dict));    
    }
}