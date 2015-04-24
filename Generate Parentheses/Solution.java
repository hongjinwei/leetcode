//@https://leetcode.com/problems/generate-parentheses/

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

*/
import java.io.*;
import java.util.*;

public class Solution {
 	private List<String> result = new LinkedList<String>();
 	int count=0;
 	int lnumber;
 	int rnumber;
 	private LinkedList<String> tmp = new LinkedList();

 	private boolean puttable(int index)
 	{
 		if(index == 2){//')'
 			if(count <= 0){//no '(' to
 				return false;
 			}else if(rnumber <= 0){
 				return false;
 			}else{
 				return true;
 			}
 		}

 		if(index == 1){//'('
 			if(lnumber <= 0){//no '(' left
 				return false;
 			}else{
 				return true;
 			}
 		}
 		return true;
 	}

 	private void put(int index){
 		if(index == 1){
 			tmp.add("(");
 			count++;
 			lnumber--;
 		}else{
 			tmp.add(")");
 			count--;
 			rnumber--;
 		}
 	}

 	private void remove(int index){
 		tmp.pollLast();
 		if(index ==1){
 			lnumber++;
 			count--;
 		}else{
 			rnumber++;
 			count++;
 		}
 	}

 	public void formatString(int remain)
 	{
 		if(remain == 0){
 			String s = "";
 			for(String x:tmp){
 				s += x;
 			}
 			result.add(s);
 		}else{
 			for(int i=1; i<=2;i++){
 				if(puttable(i)){
 					put(i);
 					formatString(remain-1);
 					remove(i);
 				}
 			}
 		}
 	}

    public List<String> generateParenthesis(int n) {
        rnumber = lnumber = n;
        formatString(2*n);
        return this.result;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	List<String> l = s.generateParenthesis(4);
    	System.out.println(l);
    	System.out.println(l.size());
    }
}