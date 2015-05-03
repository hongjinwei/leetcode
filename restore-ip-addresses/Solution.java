/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

@https://leetcode.com/problems/restore-ip-addresses/
*/
import java.io.*;
import java.util.*;

public class Solution {
    
    List<String> res = new LinkedList<String>();
    //Set<String> set = new TreeSet<String>();
    String tmp = "";
    
    public void process(String s, int index)
    {
    	String concat;
    	if(index == 4){
    		if(s.length() <=3 && Integer.parseInt(s) <= 255){
    			if(s.length() >= 2 && s.substring(0,1).equals("0")){
    				return ;
    			}
    			tmp = tmp + s;
    			//set.add(tmp);
    			res.add(tmp);
    			tmp = tmp.substring(0,tmp.length() - s.length());
    		}else{
    			return;
    		}
    	}else{	
    		for(int i=1;i<4 && i<s.length();i++){
    			if(Integer.parseInt(s.substring(0,i)) <=255){
    				concat = s.substring(0,i);
    				if(concat.length() >= 2 && concat.substring(0,1).equals("0")){
    					continue;
    				}
    				tmp = tmp + concat + ".";
    				process(s.substring(i),index+1);
    				tmp = tmp.substring(0,tmp.length()-concat.length()-1);
    			}
    		}
    	}
    }

    public List<String> restoreIpAddresses(String s) {
        if(s == null){
        	return res;
        }
        process(s,1);
        //for(String x:set){
        //	res.add(x);
        //}
        return res;
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	String t = "010010";
    	println(s.restoreIpAddresses(t));    
    }
}